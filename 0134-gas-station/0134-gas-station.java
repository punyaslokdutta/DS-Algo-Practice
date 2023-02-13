class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0;
    int currGain = 0;
    int tank =0;
    for(int counter = 0; counter< gas.length ;counter++)
    {
    	tank += gas[counter] - cost[counter];
        
    }
    if(tank<0)
    	return -1;
    int acc = 0;
    for(int i = 0;i<gas.length;i++)
    {
    	currGain = gas[i] - cost[i];
    	if(acc + currGain < 0)
    	{
    		start = i+1;
            acc = 0;
    	}
    	else
    		acc = acc + currGain;
    }
        return start;
    }
}
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int remCap = capacity;
        int n = plants.length;
        int steps = 0;
        for(int i=0;i<n;i++)
        {
            if(plants[i] > remCap)
            {
                steps += 2*i;
                remCap = capacity;
            }
            
            remCap-=plants[i];
            steps++;
        }
        
        return steps;
        
        
    }
}



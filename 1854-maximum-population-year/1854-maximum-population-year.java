class Solution {
    public int maximumPopulation(int[][] logs) {
       
       int [] y = new int[2051];
        for(int[] log : logs){
            y[log[0]]++;
            y[log[1]]--;
        }
        int maxY = 1950;
        int pop = y[1950];
        for(int i=1;i<y.length;i++){
            y[i]+=y[i-1];
            if(y[i] > pop){
                pop = y[i];
                maxY = i;
            }
        }
        return maxY;
    }
}

// [[1950,1983],[1960,1971],[1982,1996]]
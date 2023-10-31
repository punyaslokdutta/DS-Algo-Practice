class Solution {
    public int snakesAndLadders(int[][] board) {
      int n = board.length, end = n*n, result = 0;
    Queue<Integer> q = new LinkedList<>();
    
    q.add(1);
    
    while( !q.isEmpty() ){    
        result++;
        int size = q.size();
        
        while( size --> 0 ){
            int curr = q.poll();
            for( int i = 1; i <= 6; i++ ) {
                
                int next = curr+i;
                
                int[] rc = getRowCol(next, n);
                
                next = board[rc[0]][rc[1]]  == -1 ? next : board[rc[0]][rc[1]];
                
                if( next == -2 ) continue;
                
                if( next >= end ) return result;
                
                q.add(next);
                board[rc[0]][rc[1]] = -2;
            }
        }
    }
    return -1;
}

private int[] getRowCol(int idx, int n){
     int quotient = (idx-1) / n;
                int row = (n-1)-(quotient);
                int remainder = (idx-1) % n;
                int col = quotient%2==0 ? remainder : (n-1)-remainder;
    
    return new int[]{row,col};
}  
}   
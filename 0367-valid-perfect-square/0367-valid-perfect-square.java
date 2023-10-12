class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        long m =0;
        while(l<=r)
        {
            m = l + (r-l)/2;
            if(m*m == num)
            {
                return true;
            }
            else if(m*m >num)
            {
                r = (int)m-1;
            }
            else{
                l=(int)m+1;
            }
        }
        return m*m == num;
        
    }
}
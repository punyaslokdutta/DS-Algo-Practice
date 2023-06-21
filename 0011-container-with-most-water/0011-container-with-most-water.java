class Solution {
    public int maxArea(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        int ans = 0 ;
        while(l<=r)
        {
            ans = Math.max(ans , (r-l)*Math.min(height[l] , height[r]));
            if(height[l]<=height[r])
            {
                l++;
            }
            else{
                r--;
            }
        }
        
        return ans;
        
        
    }
}


//maximise to area -> maximise x  * maximise y 
// maximum y
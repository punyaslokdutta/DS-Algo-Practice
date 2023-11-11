class Solution {
    public int findKOr(int[] nums, int k) {
        int [] c= new int[32];
        for(int num : nums){
            int i=0;
            while(num>0){
                c[i++] += num&1;
                num = num>>1;
            }
        }
        
        int ans = 0;
        for(int i=0;i<32;i++){
            if(c[i]>=k) ans+=1<<i;
        }
        return ans;
        
    }
}




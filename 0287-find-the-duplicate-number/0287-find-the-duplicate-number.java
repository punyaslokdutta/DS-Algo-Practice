class Solution {
     public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[0];
        //find the loop
         do{
             s = nums[s];
             f = nums[nums[f]];
         }while(s!=f);
        //find the start of loop 
        s = nums[0];
         while(s!=f)
         {
             s = nums[s];
             f = nums[f];
         }
         return s;
    }
}



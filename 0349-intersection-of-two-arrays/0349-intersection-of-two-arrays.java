class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<Integer>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
            st.add(nums1[i]);
        for(int i=0;i<nums2.length;i++)
        {
            if(st.contains(nums2[i]))
            {
               res.add(nums2[i]);
                st.remove(nums2[i]);
            }       
        }
        return  res.stream().mapToInt(number -> number).toArray();
    }
}
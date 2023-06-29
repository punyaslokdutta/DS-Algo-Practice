class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> mp = new HashMap<>();
        for(int i=0;i<list1.length;i++)
        {
            mp.put(list1[i], i);
        }
        int minIndexSum = list1.length + list2.length;
        int currIndexSum = 0;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<list2.length;i++)
        {
            int sum = i + mp.getOrDefault(list2[i], list1.length + list2.length);
            if(minIndexSum > sum) minIndexSum = sum;
        }
        for(int i=0;i<list2.length;i++)
        {
            int sum = i + mp.getOrDefault(list2[i], list1.length + list2.length);
            if(sum == minIndexSum) ans.add(list2[i]);
        }
        
        return ans.toArray(new String[0]);
        
    }
}
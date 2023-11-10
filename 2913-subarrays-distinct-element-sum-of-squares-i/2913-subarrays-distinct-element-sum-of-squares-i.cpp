class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int x = 0;
        int c = 0;
        for(int i=0;i<nums.size();i++){
            unordered_map<int, int> ump;
            c = 0;
            for(int j=i;j<nums.size();j++){
                ump[nums[j]]++;
                if(ump[nums[j]] == 1) c++;
                x += c*c;
            }
        }
        return x;
    }
};
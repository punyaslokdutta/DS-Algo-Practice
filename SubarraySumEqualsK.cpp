class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int right=0;
        int partialSum=0;
        int n=nums.size();
        unordered_map<int, int>mp;
        //unordered_map<int, pair<int, int>> mp;
        //partialSum->{frequency, lastIndex}
        mp[0]=1;
        int ans=0;
        while(right<n)
        {
            partialSum+=nums[right++];
            ans+=mp[partialSum-k];
            // if(mp.find(partialSum-k)!=mp.end())
            //     pair<int, int> p=make_pair(mp.find(partialSum-k)[1], right);
            mp[partialSum]++;      
        }
        
        return ans;
        
    }
};


// sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it

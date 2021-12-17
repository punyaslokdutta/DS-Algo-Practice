


//4, 5, 0, -2, -3, 1
//4, 9, 9, 7, 4, 5
//r 


// There is a difference between modulus and remainder. For example:

// -21 mod 4 is 3 because -21 + 4 x 6 is 3.

// But -21 divided by 4 gives -5 with a remainder of -1.

// For positive values, there is no difference.

class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int preSum=0;
        unordered_map<int, int>ump;
        ump[0]=1;
        int ans=0;
        for(int i: nums)
        {
            preSum+=i;
            preSum=preSum%k;
             if(preSum<0)
                preSum=preSum+k;
            ans+=ump[preSum];
            ump[preSum]++;    
        }
        
        return ans;
        
    }
};


//BOYER-MOORE VOTING IMPLEMENTATION 
// Ateast n/3 elemets 

class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int cand1=-1;
        int cand2=-1;
        int count1=0;
        int count2=0;
        int n = nums.size();
        for(int i=0;i<n;i++)
        {
            if(nums[i]==cand1)
                count1++;
            else if(nums[i]==cand2)
                count2++;
            else if(count1==0){
                cand1=nums[i];
                count1++;
            }
            else if(count2==0)
            {
                cand2=nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        // cout<<"count1"<<cand1<<"\n";
        // cout<<"count2"<<cand2<<"\n";
         int freq1=0;
         int freq2=0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]==cand1)
                    freq1++;
                else if(nums[i]==cand2)
                    freq2++;    
            }
        vector<int> ans;
        if(freq1>n/3)
            ans.push_back(cand1);
        if(freq2>n/3)
            ans.push_back(cand2);
        
        return ans;
        
        
    }
};

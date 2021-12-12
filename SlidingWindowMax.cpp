class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        multiset<int> set;
        int left=0;
        int right=0;
        vector<int> res;
        for(right=0;right<nums.size();right++)
        {
            set.insert(nums[right]); //O(logN)
            if(set.size()==k)
            {
                res.push_back(*(set.rbegin()));
                set.erase(set.find(nums[left++]));
            }        
        }
        return res;
        
    }
};

// rbegin is actually the last element of your container. end is one past the end of the container.
// So marks.end()->second is undefined behavior.

// begin() returns an iterator to the first element and rbegin() returns an iterator to an element kept at the end of the vector
// The explanation is: begin() is used to return the iterator to the first element of the vector whereas rbegin()
// is used to return the an element stored at in the last of a vector.



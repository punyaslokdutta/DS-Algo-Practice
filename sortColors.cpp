


// r, w, r, b, w, w, r, b, b, r, w, 
//R->W->B
//0->1->2

//low, mid, high
//[0......low-1] ->0
//[high+1....n-1]->2
//[low+1, high-1] ->mid processing and swappinga accordingly




// class Solution {
// public:
//     void sortColors(vector<int>& nums) {
//         int l=0;
//         int m=0;
//         int n= nums.size();
//         int h=n-1;
        
//         while(m<=h)
//         {
//             switch(nums[m])
//             {
//                 case 0:
//                     swap(nums[m++], nums[l++]);
//                     break;
//                 case 1:
//                     m++;
//                     break;
//                 case 2:
//                     swap(nums[m], nums[h--]);
//                     break;
   
//             }
//         }
        
//     }
// };
class Solution{
    public:
void sortColors(vector<int>& nums) {
       int ptr1 = 0;  // starting pointer 
       int ptr2 = nums.size()-1;  // end pointer
       int curr = 0;  // current pointer
        while(curr <= ptr2) {  // if current pointer less than equal to end pointer
            if(nums[curr] == 0) {
                swap(nums[ptr1], nums[curr]);  // if 0 found then swap with current and start pointer values
                ptr1++;  // move start pointer one step ahead
                curr++;  // move current pointer one step ahead
            }
            else if(nums[curr] == 1) {
                curr++;  // if current pointer at 1 then just move the current pointer ahead
            }
            else if(nums[curr] == 2) {
                swap(nums[ptr2], nums[curr]);  // if current pointer is 2 then swap values of current and end pointed values
                ptr2--;  // move end pointer one step back
            }
        }
	}
};


//2, 2, 2, 2, 5, 5, 5, 8
//2, 4, 6, 8, 13, 18, 23, 31
//SUM+ = ARR[I]-ARR[I-K]
class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        
        int n= arr.size();
        int sum=0;
        //int prefixSum[n];
        int ans=0;
        int val=threshold*k;
        for(int i=0;i<n;i++)
        {
            
            //prefixSum[i]=sum;
            
            if(i>=k)
            {
                sum+=arr[i]-arr[i-k];
                //int div=(prefixSum[i]-prefixSum[i-k]);
                if(sum>=val)
                {
                    ans++;
                } 
            }
            else
            {
              sum+=arr[i];
              if(i==k-1 && sum>=val)
              {
                  ans++;
              }
                
            }  
        }
        
        return ans;
        
    }
};

// class Solution {
// public:
// 	int numOfSubarrays(vector<int>& arr, int k, int threshold) {
// 		int t = k * threshold;
// 		int s = 0;
// 		int c = 0;
// 		for(int i = 0; i < k; i++){
// 			s += arr[i];
// 		}
// 		if(s >= t){
// 			c++;
// 		}
// 		for(int i = k; i < arr.size(); i++){
// 			s += arr[i] - arr[i - k];
// 			if(s >= t){
// 				c++;
// 			}
// 		}        
// 		return c;
// 	}
// };

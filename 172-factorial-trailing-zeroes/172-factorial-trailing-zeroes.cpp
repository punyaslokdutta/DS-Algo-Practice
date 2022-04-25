#define ll long long 
class Solution {
public:
    int trailingZeroes(int n) {
        long long  i = 1;
        int count = 0;
        while(n > 0)
        {
            count += n/5;
            n = n/5;
        }
        return count;
    }
};
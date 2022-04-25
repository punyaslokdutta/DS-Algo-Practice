
//SQUARE ROOT USING NEWTON DIVISION METHOD 

class Solution {
public:
    int mySqrt(int x) {
        long s = x;
        while(s*s > x)
        {
            s = (s + x/s)/2;
        }
        return s;
    }
};

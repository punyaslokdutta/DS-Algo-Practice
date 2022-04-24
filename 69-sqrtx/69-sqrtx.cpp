
//SQUARE ROOT USING NEWTON DIVISION METHOD 

class Solution {
public:
    int mySqrt(int x) {
    long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return r;
        
    }
};

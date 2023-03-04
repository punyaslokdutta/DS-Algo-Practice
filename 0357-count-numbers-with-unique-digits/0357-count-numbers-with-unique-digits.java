
//f(0) = 1, f(1) = 9, f(2) = 9*9*8 , f(3) = 9*9*8*7

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        
        int remaining = 9;
        int unique = 9;
        int res = 10;
        while(n-- > 1 && remaining>1 )
        {
            unique = unique*remaining;
            res+= unique;
            remaining--;
        }
        return res;
        
    }
}
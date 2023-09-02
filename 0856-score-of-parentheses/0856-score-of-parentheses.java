class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int score = 0;
        for(int i=0;i<n;i++)
        {
            char c= s.charAt(i);
            if(c == '(')
            {
                st.push(score);
                score = 0;
            }
            else{
                score = st.pop() + Math.max(2*score, 1);
            }
        }
        return score;
        
    }
}



// a-> (()()) b-> (())
// ab -> a+b -> 6 
//     a-> 4 
//     b -> 2 
//     C-> ()() -> 2 
//     (()) -> 2*1 = 2


// (()())(())
// (1 1)(1)
// (2) 2
// 4 + 2 = 6 
    

// 1 1())(())
// 0  
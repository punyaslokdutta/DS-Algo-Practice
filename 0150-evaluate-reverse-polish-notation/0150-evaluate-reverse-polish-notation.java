class Solution {
    public int evalRPN(String[] tokens) {

    Stack<Integer> st = new Stack<>();
    Set<String> operands = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    for(String i: tokens )
    {
    	if(!operands.contains(i))
    	{
    		st.push(Integer.valueOf(i));
    	}
    	else{
    	int a = st.pop();
    	int b = st.pop();
    	if(i.equals("+"))
    		st.push(a+b);
    	else if(i.equals("-"))
    		st.push(b-a);
    	else if(i.equals("*"))
    		st.push(a*b);
    	else
    		st.push(b/a);
    	}
    }
        
      return st.peek();  
    }
}
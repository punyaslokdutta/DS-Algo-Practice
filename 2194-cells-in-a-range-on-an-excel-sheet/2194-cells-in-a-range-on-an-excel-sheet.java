class Solution {
    public List<String> cellsInRange(String s) {
        int  initialCol = s.charAt(0);
        int  finalCol = s.charAt(3);
        int  initialRow = s.charAt(1);
        int finalRow = s.charAt(4);
        List<String> ans = new ArrayList<>();
        for(int i = initialCol ;i<=finalCol;i++)
        {
            for(int j=initialRow;j<=finalRow;j++)
            {
                char[]ch = new char[2];
                ch[0]=(char)i;
                ch[1]=(char)j;
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
        
    }
}
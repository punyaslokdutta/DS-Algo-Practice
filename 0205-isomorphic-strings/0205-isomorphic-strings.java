
// egge , adda
//e-> a , 


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> mp = new HashMap<>();
        for (int i = 0;i<s.length();i++)
        {
            //System.out.println(mp);
            if(!mp.containsKey(s.charAt(i)) )
            {
                if(mp.containsValue(t.charAt(i)))
                    return false;
                mp.put(s.charAt(i), t.charAt(i));
            }
            else
            {
                if(mp.get(s.charAt(i))!= t.charAt(i))
                    return false;
            }
        } 
        return true;
    }
}
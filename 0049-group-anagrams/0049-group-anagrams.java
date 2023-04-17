class Solution{
	List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> mp = new HashMap<>();
		for(String str : strs)
		{
			char [] ch = new char[26];
			for(char c: str.toCharArray())
			{
			 ch[c -'a']++;
			}
			String temp = String.valueOf(ch);
			if(!mp.containsKey(temp))
				mp.put(temp, new ArrayList<>());
			mp.get(temp).add(str);
		}

		return new ArrayList<>(mp.values());
	}
}
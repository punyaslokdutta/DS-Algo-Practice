public class Solution {
    private TrieNode root = new TrieNode();
    public boolean wordBreak(String str, List<String> wordDict) {
        for (String word : wordDict)
            addToTrie(word);
        boolean[] dp = new boolean[str.length() + 1];
        char[] s = str.toCharArray();
        dp[0] = true;
        for (int i = 0; i < s.length; i++) {
            if (!dp[i])
                continue;
            int j = i; // start trie traversal
            TrieNode cur = root;
            while (j < s.length && cur.children[s[j] - 'a'] != null) {
                cur = cur.children[s[j++] - 'a'];
                if (cur.isWord)
                    dp[j] = true;
            }
        }
        return dp[str.length()];
    }

    private void addToTrie(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null)
                cur.children[ch - 'a'] = new TrieNode();
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
    }
}
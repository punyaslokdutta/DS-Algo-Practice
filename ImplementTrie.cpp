class Trie {
    
private:
    struct TrieNode{
        struct TrieNode* children[26];
        bool isEnd;
        TrieNode()
        {
        isEnd=false;
        for(int i=0;i<26;i++){
            children[i]=NULL;
        }
        }
    };
    TrieNode* root;
    
public:
    Trie() {
        root=new TrieNode();   
    }
    
    void insert(string word) {
        TrieNode* curr=root;
        for(char c:word)
        {
            if(curr->children[c-'a']==NULL)
            {
                curr->children[c-'a'] =new TrieNode();    
            }
            curr=curr->children[c-'a'];
        }
        curr->isEnd=true;
        
    }
    
    bool search(string word) {
        TrieNode* curr=root;
        for(char c: word)
        {
            if(curr->children[c-'a']==NULL)
            {
                return false;
            }
            curr=curr->children[c-'a'];
        }
        return curr->isEnd;
        
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr=root;
        for(char c: prefix)
        {
            if(curr->children[c-'a']==NULL)
                return false;
            curr=curr->children[c-'a'];
        }
        
        return true;
        
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

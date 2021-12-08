/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
//PostOrder->{left, right, root}
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        stack<TreeNode*> st;
        vector<int> ans;
        TreeNode * p= root;
        while(p!=NULL || !st.empty())
        {
            while(p)
            {
            st.push(p);
            p=p->left; // move towards the leftpart of the subtree
            }
            TreeNode *t= st.top()->right; //is there any right of it 
            if(t) p=t; //if there is a right , traversal pointer is made same .
            else
            { //if there's no right subtree of the node, Find it's parent from the top of the stack after inserting the val
                t=st.top();
                st.pop();
                ans.push_back(t->val);
                while(!st.empty() && st.top()->right == t)
                {
                    t=st.top();
                    st.pop();
                    ans.push_back(t->val);
                }
            }  
        } 
        return ans;   
    }
};

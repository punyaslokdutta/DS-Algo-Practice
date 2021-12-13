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
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        
       //ITERATIVE SOLUTION USING QUEUES
        
        if(root)
        {
            queue<TreeNode*> q;
            q.push(root);
            while(!q.empty())
            {
                TreeNode* front=q.front();
                //swap the left and right
                q.pop();
                //insert into swapped nodes in the queue
                TreeNode* temp= front->left;
                front->left=front->right;
                front->right=temp;
                if(front->left)
                    q.push(front->left);
                if(front->right)
                    q.push(front->right);                
            }
        }
        
        return root;
    }
};



//RECURSIVE SOLUTION 


// if(!root)
        //     return root;
        // TreeNode* left=root->left;
        // TreeNode* right= root->right;
        // TreeNode* temp =left;
        // root->left=root->right;
        // root->right=temp;
        // root->left=invertTree(root->left);
        // root->right=invertTree(root->right);
        // return root;

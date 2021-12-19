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

// [8:31 PM, 12/19/2021] .: Full v.s. Complete Binary Trees. A full binary tree (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has two children. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
// [8:32 PM, 12/19/2021] .: Perfect Binary Tree A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level.


// class Solution {
// public:
//     bool isCompleteTree(TreeNode* root) {
//         bool res=false;
//         if(!root)
//             return true;
//         queue<TreeNode*> q;
//         q.push(root);
//         while(q.size()>0)
//         {
//             TreeNode* p=q.front();
//             q.pop();
//             if(p==NULL)
//                 res=true; //ONE NULL VALUE IS FOUND //NEXT NULL MEANS NOT A COMPLETE TREE
//             else
//             {
//                 if(res)
//                 {
//                   return false;       //NUL ISNT THE LAST VALUE IN THE TREE  
//                 }
//                 q.push(p->left);
//                 q.push(p->right);
//             }
//         }
        
//         return true;
        
//     }
// };

class Solution{
    public:
bool isCompleteTree(TreeNode* root) {
    queue<TreeNode *> q;
    q.push(root);
    bool flag=false;
    while(q.size()){
            TreeNode * node=q.front();
            q.pop();
            if(node->left==NULL)
                flag=true;
            else{
                if(flag)
                    return false;
                q.push(node->left);
            }
            
            if(node->right==NULL)
                flag=true;
            else{
                if(flag==true)
                    return false;
                q.push(node->right);
            }
        }
    
    return true;
}
};

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
    TreeNode* prev=nullptr;
    void flatten(TreeNode* root) {
        if(!root) return;
        flatten(root->right);
        flatten(root->left); 
        
        root->left=nullptr; 
        root->right=prev;
        prev=root;
    }
};

// class Solution {
// public:
//     void flatten(TreeNode* root) {
//         if(root == NULL){
//             return;
//         }
//         flatten(root->left);
//         flatten(root->right);
//         if(root->left){
//             TreeNode *right = root->right;
//             root->right = root->left;
//             root->left = NULL;
//             while(root->right) root = root->right;
//             root->right = right;
//         }
//     }
// };
// class Solution {
// public:
//     void flatten(TreeNode* root) {
//         if(root == NULL){
//             return;
//         }
//         TreeNode *curr = root;
//         while(curr){
//             if(curr->left){
//                 TreeNode *pre = curr->left;
//                 while(pre->right){
//                     pre = pre->right;
//                 }
//                 pre->right = curr->right;
//                 curr->right = curr->left;
//                 curr->left = NULL;
//             }
//             curr = curr->right;
//         }
//     }
// };

// class Solution {
// public:
//     void flatten(TreeNode* root) {
//         if( root )
//         {
//             /*Move the left node to the right node*/
//             TreeNode* temp = root->right;
//             root->right = root->left;
//             root->left = nullptr;
//             TreeNode* node = root;
            
//             /*Move to the end of the prev left node which is the new right node*/
//             while( node->right )
//             {
//                 node = node->right;
//             }
            
//             /*Append the right node to its end*/
//             node->right = temp;
//             flatten( root->right ); 
//         } 
//         return;
               
//     }
// };

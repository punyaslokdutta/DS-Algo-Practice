/************************************************************

    Following is the Binary Tree node structure
    
    template <typename T>
    class TreeNode {
        public :
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this -> data = data;
            left = NULL;
            right = NULL;
        }

        ~TreeNode() {
            if(left)
                delete left;
            if(right)
                delete right;
        }
    };

************************************************************/
class info
{
    public:
    int maxi;
    int mini;
    bool isBST;
    int size; //size at each subtree 
    
};
info findLargestBST(TreeNode<int>* root, int &maxSize)
{
    if(!root)
        return {INT_MIN, INT_MAX, true, 0};
//     if(root->left==NULL && root->right==NULL)
//         return {root->data, root->data, true, 1};
    info left = findLargestBST(root->left, maxSize);
    info right = findLargestBST(root->right, maxSize);
    //check bst
    
    info curr;
    curr.maxi= max(right.maxi, root->data);
    curr.mini= min(left.mini, root->data);
    curr.size= left.size + right.size +1;
    
    if(left.isBST && right.isBST && (root->data>left.maxi && root->data <right.mini))
    {
        curr.isBST=true;
        //curr.size = left.size + right.size +1;
        //maxSize= max(maxSize, curr.size);
    }
    else
    {
        curr.isBST=false;
//         curr.maxi=INT_MIN;
//         curr.mini=INT_MAX;
//         curr.size= max(left.size, right.size);
    }
    if(curr.isBST)
    {
        maxSize= max(maxSize, curr.size);
    }
    return curr;
}
int largestBST(TreeNode<int>* root) 
{
    int maxSize=0;
    info ans=findLargestBST(root, maxSize);
    // Write your code here.
    return maxSize;
}






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
// You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] 
// indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree described by descriptions and return its root.

//15->20
//17->20
//20->50
//80->50
//19->80

class Solution {
private:
    map<int, TreeNode*> nodeMap;
public:
    TreeNode* getNode(int val)
    {
        TreeNode* newNode;
        if(nodeMap[val])
            return nodeMap[val];
        else
        {
            newNode= new TreeNode(val);
            nodeMap[val]= newNode; //insert into the map
            return newNode;
        }
    }
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        
        unordered_set<TreeNode*> childSet;
        for(auto d: descriptions)
        {
            int parVal = d[0];
            int childVal = d[1];
            bool isLeft = d[2];
            TreeNode* node = getNode(parVal);
            if(isLeft)
            {
                node->left= getNode(childVal);
                childSet.insert(node->left);
            }
            else
            {
                node->right=getNode(childVal);
                childSet.insert(node->right);
            }
        }
        TreeNode* ans;
        for(auto p: nodeMap)
        {
            if(childSet.find(p.second)==childSet.end())
                ans= p.second;
        }
        return ans;
    }
};

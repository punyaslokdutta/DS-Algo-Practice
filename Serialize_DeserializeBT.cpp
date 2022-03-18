/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */


// Serialization is usually used When the need arises to send your data over network or stored in files. By data I mean objects and not text. Now the problem is your Network infrastructure and your Hard disk are hardware components that understand bits and bytes but not JAVA objects.

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        
    if (root == nullptr) return "";
    
    string ss;
    queue<TreeNode*> q;
    q.push(root);
    
    while (!q.empty()) {
        auto curr = q.front();
        q.pop();
        
        if (curr != nullptr) {
            ss.append(to_string(curr->val));
        
            if (curr->left) q.push(curr->left);
            else q.push(nullptr);
            
            if (curr->right) q.push(curr->right);
            else q.push(nullptr);
        }
        
        ss.append(",");
    }
    
    return ss;
    //  string s="";
    //  queue<TreeNode*>q;
    //  q.push(root);
    //  while(!q.empty())
    //  {
    //      auto f=q.front();
    //      q.pop();
    //      if(f==NULL)
    //          s.append("#");
    //      else 
    //          s.append(to_string(f->val)+',');
    //      if(f!=NULL)
    //      {
    //          q.push(f->left);
    //          q.push(f->right);
    //      }  
    //  }
    // return s;
        
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if (data.empty()) return nullptr;
    
    istringstream ss(data);
    TreeNode* root = nullptr;
    string token;
    
    getline(ss, token, ',');
    root = new TreeNode(stoi(token));

    queue<TreeNode*> q;        
    q.push(root);
    while (!q.empty()) {
        TreeNode* node = q.front();
        q.pop();
        
        getline(ss, token, ',');
        if (!token.empty()) {
            node->left = new TreeNode(stoi(token));
            q.push(node->left);
        }
        
        getline(ss, token, ',');
        if (!token.empty()) {
            node->right = new TreeNode(stoi(token));
            q.push(node->right);
        }
    }
    
    return root;
//         if(data.size()==0)
//             return NULL;
//         stringstream s(data); //converts string into stream
//         string str;
//         getline(s, str, ',');  
//         if(str=="#")
//             return NULL;
//         TreeNode* root= new TreeNode(stoi(str));
//         queue<TreeNode*> q;
//         q.push(root);
//         while(!q.empty())
//         {
//             TreeNode* f= q.front();
//             q.pop();
//             getline(s, str, ',');
//             if(str=="#")
//                 f->left=NULL;
//             else
//             {
//                 TreeNode* leftNode= new TreeNode(stoi(str));
//                 f->left=leftNode;
//                 q.push(leftNode);
//             }
//             getline(s, str, ',');
//             if(str=="#")
//                 f->right=NULL;
//             else
//             {
//                 TreeNode* rightNode= new TreeNode(stoi(str));
//                 f->right=rightNode;
//                 q.push(rightNode);
//             }
//         }
        
//         return root;
        
    } 
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));

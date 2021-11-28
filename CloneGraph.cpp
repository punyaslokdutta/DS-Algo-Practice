/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node == nullptr)
            return nullptr;
        
        // this is the mapping for nodes in original graph 
        // to respective nodes in the clone graph
        map<Node*, Node*> mp;
        // queue for BFS traversal
        queue<Node*> q;
        
        // add the initial node and its clone to queue as well as map
        Node* clone = new Node(node->val);
        q.push(node);
        mp.insert({node, clone});
        
        while(!q.empty())
        {
            // take out node on by one from the qeueu
            auto cur = q.front();
            q.pop();
            
            // traverse all the children of the cur node
            auto children = cur->neighbors;
            for(auto child : children)
            {   
                // if the child is not present in the clone 
                // this also means that the child is unvisited 
                // so add that child to the queue as well
                if(mp[child] == NULL)
                {
                    // create a clone node and add it to the map
                    Node* temp = new Node(child->val);
                    mp[child] = temp;
                    // qeue will always have node from original graph
                    // remember we are traversing original graph 
                    q.push(child);
                }
                // add the nodes in the adj list of node of clone graph
                mp[cur]->neighbors.push_back(mp[child]);
            }
        }
        return mp[node];
    }
};

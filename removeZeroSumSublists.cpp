


//UNORDERED_MAP + PARTIALSUM + LINKED LIST + ERASING FROM UMAP + SETTING THE NEXT POINTER CORRECTLY TO REMOVE NODES 

// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
// After doing so, return the head of the final linked list.  You may return any such answer.

// Input: head = [1,2,-3,3,1]
// Output: [3,1]
// Note: The answer [1,2,1] would also be accepted.
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
     ListNode* removeZeroSumSublists(ListNode* head) {
         ListNode * temp = new ListNode(0);
         temp->next= head;
         unordered_map<int, ListNode*> ump;
         int partialSum=0;
         ListNode* curr = temp;
         while(curr!=NULL)
         {
             partialSum+=curr->val;
             if(ump[partialSum])
             {
                 curr = ump[partialSum]->next;
                 int p = partialSum + curr->val;
                 while(p!=partialSum)
                 {
                     ump.erase(p);
                     //DEALLOCATE MEMORY FOR THE NODE 
                     curr= curr->next;
                     p+=curr->val;
                 } 
                 ump[partialSum]->next=curr->next;
             }
             else{
                 ump[partialSum]=curr; //ump[0]=temp;
             }
             curr=curr->next;
         }
         return temp->next;
         
         
     }
};

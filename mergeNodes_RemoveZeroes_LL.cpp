

//MERGE NODES BY SUMMING NODE VALUES BETWEEN ZERO VALUED NODES
// 1. 0->1->2->3->0->4->3->0
// output: 6->7
// 2. 0->3->4->0->0->7->2->0->1->0
// output: 7->9->1




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
    ListNode* mergeNodes(ListNode* head) {
       ListNode* curr= head->next;
       ListNode* t=head;
       while(curr!=NULL)
       {
           if(curr->val!=0)
           {
               t->val+=curr->val;
           }
           else{
               
               //move to rightmost zero && update the  temp->next= rightmost zero && temp=curr
               while(!curr && !curr->next && curr->val==0 && curr->next->val==0)
               {
                   curr=curr->next;
               }
               if(curr->next==NULL)
               {
                   t->next=NULL;
               }
               else{
               t->next=curr;
               }
               t=curr;
           }
           curr=curr->next;
       }
        return head;
    }
};

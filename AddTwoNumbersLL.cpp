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
     ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        int temp;
		// Storing the head of l1 as that will be returned eventually
        ListNode* addedList = l1;
        ListNode * previous;
		
        while(l1 != nullptr && l2 != nullptr) {
            temp = l1->val + l2->val + carry;
            l1->val = temp % 10;
            carry = temp/10;
            previous = l1;
            l1 = l1->next;
            l2 = l2->next;
        }

        if(l2 == nullptr) {
            //l1 is bigger and l2 is null.
			// Add carry to l1 and return
            while(l1 != nullptr && carry != 0){
                temp = l1->val + carry;
                l1->val = temp % 10;
                carry = temp / 10;
                previous = l1;
                l1 = l1->next;
            }
        }
        else {
            // l1 is smaller. Point the last node of l1 to current node of l2
            previous->next = l2;
            while(l2 != nullptr && carry != 0){
                temp = l2->val + carry;
                l2->val = temp % 10;
                carry = temp / 10;
                previous = l2;
                l2 = l2->next;
            }            
        }

		// If carry is still remaining, create a new Node and add it to end
        if(carry != 0) {
            ListNode * newNode = new ListNode(carry);
            previous->next = newNode;
        }

        return addedList;
    }
};


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> sub = new ArrayList<>();
        while(head!=null){
            sub.add(head.val);
            head = head.next;
        }
        int n = sub.size();
        int [] ans = new int[n];
        Stack<Integer> st = new Stack();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && sub.get(i) > sub.get(st.peek())){
                ans[st.pop()] = sub.get(i);
            }
            st.push(i);
        }
        
        return ans;
        
    }
}
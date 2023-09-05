/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> mp = new HashMap<>();
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        if(mp.containsKey(head)) return mp.get(head);
        Node curr = new Node(head.val);
        mp.put(head, curr);
        curr.next = copyRandomList(head.next);
        curr.random = copyRandomList(head.random);
        return curr;
    }
}



// a->b->c
//  d->e->f
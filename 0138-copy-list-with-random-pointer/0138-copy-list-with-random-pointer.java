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
    private Map<Node, Node> mp = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        if(mp.containsKey(head))
            return mp.get(head);
        
        Node newNode = new Node(head.val);
        mp.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?, level: Int = 0, levels: ArrayList<Node?> = ArrayList()): Node? {
    if(root != null) {
        if(levels.size <= level) levels.add(root) else {
            levels[level]?.next = root
            levels[level] = root
        }
        connect(root.left, level + 1, levels)
        connect(root.right, level + 1, levels)
    }
    return root
}
}
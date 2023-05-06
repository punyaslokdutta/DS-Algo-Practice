/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexUmp;

    public TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int inorderPivotIndex = inorderIndexUmp.get(rootValue);
        root.left = buildTreeHelper(preorder, left, inorderPivotIndex - 1);
        root.right = buildTreeHelper(preorder, inorderPivotIndex + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexUmp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexUmp.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }
}
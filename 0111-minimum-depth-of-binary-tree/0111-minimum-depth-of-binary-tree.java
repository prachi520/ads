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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        return (minLeft == 0 || minRight == 0)
                ? minLeft + minRight + 1
                : Math.min(minLeft, minRight) + 1;
    }
}
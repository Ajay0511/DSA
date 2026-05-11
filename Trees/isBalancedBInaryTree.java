/*
Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/
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
    private boolean isBalanced = true;
    public int height(TreeNode root){

        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) > 1){
            isBalanced = false;
        }
        return 1 + Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
}

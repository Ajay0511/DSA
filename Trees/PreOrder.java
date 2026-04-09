/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Explanation:

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [1,2,4,5,6,7,3,8,9]

Explanation:

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
        // List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // if(root!=null){
        //     st.push(root);
        // }
        // while(!st.isEmpty()){
        //     TreeNode node = st.pop();
        //     res.add(node.val);
        //     if(node.right != null){
        //         st.push(node.right);
        //     }
        //     if(node.left != null){
        //         st.push(node.left);
        //     }
        // }
        // return res;
    }
}

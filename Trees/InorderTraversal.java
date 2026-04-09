/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]


Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]


Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

        // List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // while(true){
        //     while(root != null){
        //         st.push(root);
        //         root = root.left;
        //     }
        //     if(st.isEmpty()){
        //         return res;
        //     }
        //     TreeNode node = st.pop();
        //     res.add(node.val);
        //     root = node.right;
        // }
    }
}
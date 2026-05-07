/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean left_to_right = false;


        while(!q.isEmpty()){
            LinkedList<Integer> curr = new LinkedList<>();
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(left_to_right){
                    curr.addFirst(node.val);
                } else{
                    curr.addLast(node.val);
                }
                
                
                if(node.left != null){
                    q.add(node.left);
                } 
                if(node.right != null){
                    q.add(node.right);
                }
                
            }
            res.add(curr);
            left_to_right = !left_to_right;
        }
        return res;
    }
}

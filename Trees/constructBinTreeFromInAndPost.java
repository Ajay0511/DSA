/*
Given two integer Array inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.

Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
*/

class Solution {
    private Map<Integer, Integer> mp = new HashMap<>();
    private int postIndex;
    private TreeNode helper(int[] postorder, int inStart, int inEnd){
        if(inStart>inEnd || postIndex<0){
            return null;
        }

        int val = postorder[postIndex];
        postIndex-=1;

        TreeNode root = new TreeNode(val);
        int idx = mp.get(val);
        root.right = helper(postorder, idx+1,inEnd);
        root.left = helper(postorder, inStart,idx-1);
        
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i =0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }

        postIndex = postorder.length-1;
        return helper(postorder, 0, inorder.length-1);
    }
}

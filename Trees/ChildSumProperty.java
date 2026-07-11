/*
Given the root of a binary tree, determine whether the tree satisfies the Children Sum Property. In this property, each non-leaf node must have a value equal to the sum of its left and right children's values. A NULL child is considered to have a value of 0, and all leaf nodes are considered valid by default.
Return true if every node in the tree satisfies this condition, otherwise return false.

Examples:

Input: root = [35, 20, 15, 15, 5, 10, 5]

Output: True
Explanation: Here, every node is sum of its left and right child.
Input: root = [1, 4, 3, 5]
  
Output: False
Explanation: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 105
*/

/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return (root != null ? root.data : 0) ==  
            (root.right != null ? root.right.data : 0) + 
            (root.left != null ? root.left.data : 0) && 
            isSumProperty(root.left) &&
            isSumProperty(root.right);
    }
}

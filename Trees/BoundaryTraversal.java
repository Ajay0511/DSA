/*
Given a root of a Binary Tree, return its boundary traversal in the following order:

Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
*/
/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    void dfs(Node root, ArrayList<Integer> leaf){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaf.add(root.data);
        }
        dfs(root.left, leaf);
        dfs(root.right, leaf);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);
        if(root.right == null && root.left == null){
            return res;
        }
        ArrayList<Integer> left = new ArrayList<>(); 
        ArrayList<Integer> right = new ArrayList<>(); 
        ArrayList<Integer> leaf = new ArrayList<>(); 
        Node l = root.left;
        while(l!=null){
            if(l.left == null && l.right == null){
                break;
            }
            left.add(l.data);
            if(l.left != null){
                l = l.left;
            } else if(l.right != null){
                l = l.right;
            }
        }
        
        Node r = root.right;
        while(r!=null){
            if(r.left == null && r.right == null){
                break;
            }
            right.add(r.data);
            if(r.right != null){
                r = r.right;
            } else if(r.left != null){
                r = r.left;
            }
        }
        
        dfs(root,leaf);
        res.addAll(left);
        res.addAll(leaf);
        Collections.reverse(right);
        res.addAll(right);
        return res;
    }
}

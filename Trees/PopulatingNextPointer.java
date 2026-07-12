/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/



/* Iterative
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return root;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node prev = null;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(prev != null){
                    prev.next = curr;
                }
                prev = curr;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                
            }
            prev.next = null;
        }
        return root;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null || root.left == null){
            return root;
        }
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

/*
You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note:

Return the nodes from the leftmost node to the rightmost node.
If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 
Examples:

Input: root = [1, 2, 3]
Output: [2, 1, 3]
Explanation: The Green colored nodes represents the top view in the below Binary tree.
 
Input: root = [10, 20, 30, 40, 60, 90, 100]
Output: [40, 20, 10, 30, 100]
Explanation: The Green colored nodes represents the top view in the below Binary tree.


Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
*/

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}


class Pair{
    Node node;
    int col;
    public Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> topView = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            Node node = pair.node;
            int col = pair.col;
            if(!topView.containsKey(col)){
                topView.put(col, node.data);
            }
            if(node.left != null){
                q.add(new Pair(node.left, col-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, col+1));
            }
        }
        
        for(int i : topView.values()){
            res.add(i);
        }
        return res;
    }
}
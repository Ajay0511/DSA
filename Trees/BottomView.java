/*

You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

Examples :

Input: root = [1, 2, 3, 4, 5, N, 6]
    
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

import java.util.ArrayList;
import java.util.TreeMap;

class Pair{
    int val;
    int depth;
    
    Pair(int val, int depth){
        this.val = val;
        this.depth = depth;
    }
}

class Solution {
    public void helper(Node root, Map<Integer, Pair> mp, Integer column, Integer depth){
        if(root == null){
            return;
        }
        if(!mp.containsKey(column) || depth >= mp.get(column).depth ){
            mp.put(column, new Pair(root.data, depth));
        }
        
        helper(root.left, mp, column-1, depth+1);
        helper(root.right, mp, column+1, depth+1);
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Pair> mp = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, mp, 0, 0);
        for(Map.Entry<Integer, Pair> entry : mp.entrySet()){
            res.add(entry.getValue().val);
        }
        return res;
        
    }
}
*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;

class Pair{
    Node nd;
    int col;
    
    Pair(Node nd, int col){
        this.nd = nd;
        this.col = col;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Integer> mp = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        if(root == null){
            return res;
        }
        while(!q.isEmpty()){
            Pair piar = q.poll();
            mp.put(piar.col, piar.nd.data);
            
            if(piar.nd.left != null){
                q.add(new Pair(piar.nd.left, piar.col-1));
            }
            if(piar.nd.right != null){
                q.add(new Pair(piar.nd.right, piar.col+1));
            }
            
        }
        for(Integer a : mp.values()){
            res.add(a);
        }
        return res;
        
    }
}

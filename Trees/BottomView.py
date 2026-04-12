"""
You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

Examples :

Input: root = [1, 2, 3, 4, 5, N, 6]
    
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
"""
"""
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

def bottomView(self, root):
        # code here
        res = {}
        def helper(root,res,dist,level):
            if not root:
                return 
            if dist not in res or level >= res[dist][1]:
                res[dist] = (root.data,level)
            helper(root.left,res,dist-1,level+1)
            helper(root.right,res,dist+1,level+1)
        
        helper(root,res,0,0)
        ans = []
        for key in sorted(res.keys()):
            ans.append(res[key][0])
        return ans
"""

def bottomView(self, root):
    if not root:
        return []
    
    res = {}
    
    def helper(root, res, dist, level):
        if not root:
            return
        if dist not in res or level >= res[dist][1]:
            res[dist] = (root.data, level)
        helper(root.left, res, dist - 1, level + 1)
        helper(root.right, res, dist + 1, level + 1)
    
    helper(root, res, 0, 0)
    
    # Extract the values from res based on the keys in sorted order
    min_dist = min(res.keys())
    max_dist = max(res.keys())
    
    ans = []
    for dist in range(min_dist, max_dist + 1):
        ans.append(res[dist][0])
    
    return ans

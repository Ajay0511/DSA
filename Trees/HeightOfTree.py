"""
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
"""

def maxDepth(self, root: Optional[TreeNode]) -> int:
        maxx = -1
        queue = [(root,1)]
        while(queue):
            item = queue.pop(0)
            node = item[0]
            maxx = max(maxx,item[1])
            le = item[1]
            if node.left:
                queue.append((node.left,le+1))
            if node.right:
                queue.append((node.right,le+1))
        return maxx

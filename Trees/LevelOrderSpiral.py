"""
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return 
        stack1 = [root]
        stack2 = []
        ans = []

        while stack1 or stack2:
            curr = []

            while(stack1):
                node = stack1.pop()
                if node.left:
                    stack2.append(node.left)
                if node.right:
                    stack2.append(node.right)
                curr.append(node.val)
            
            if curr:
                ans.append(curr)
                curr = []
            

            while(stack2):
                node = stack2.pop()
                if node.right:
                    stack1.append(node.right)
                if node.left:
                    stack1.append(node.left)
                curr.append(node.val)
            if curr:
                ans.append(curr)
                curr = []

        return ans

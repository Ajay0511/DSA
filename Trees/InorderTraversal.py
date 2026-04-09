"""
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]


Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]


Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional, List
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
       
        st = []
        def helper(root,st):
            if root is None:
                return 
            helper(root.left,st)
            st.append(root.val)
            helper(root.right,st)
        helper(root,st)
        return st

         # res,st = [],[]
        # while(True):
        #     while(root):
        #         st.append(root)
        #         root = root.left
        #     if not st:
        #         return res
        #     node = st.pop()
        #     res.append(node.val)
        #     root = node.right
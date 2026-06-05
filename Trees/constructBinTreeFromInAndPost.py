"""
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
"""

def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_idx = {v:i for i,v in enumerate(inorder)}

        def helper(l,r):
            if l>r:
                return None
            
            root = TreeNode(postorder.pop())
            idx = inorder_idx[root.val]

            #build right subtree first
            root.right = helper(idx+1,r)
            root.left = helper(l,idx-1)
            return root
        return helper(0,len(inorder)-1)

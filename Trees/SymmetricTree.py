"""
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

"""

def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        def helper(left,right):
            if not left and not right:
                return True
            if not right or not left:
                return False
            
            if left.val == right.val:
                outPair = helper(left.left,right.right)
                inPair = helper(left.right,right.left)
                return outPair and inPair
            else:
                return False
        
        return helper(root.left,root.right)

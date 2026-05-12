"""
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
"""

def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        self.lis1 = []
        self.lis2 = []

        def helper(root,desc):
            if not root:
                return 
            if  self.lis1 and  self.lis2:
                return
            desc.append(root)
            if root == p:
                self.lis1 = desc.copy()
            elif root == q:
                self.lis2 = desc.copy()
            
            helper(root.left,desc)
            helper(root.right,desc)
            desc.pop()                            #to avoid all paths been taken, backtracking done
        helper(root,[])
        lca = None
        for item1, item2 in zip(self.lis1,self.lis2):
            if item1 == item2 :
                lca = item1        #running till get the last same element
            else:
                break

        return lca

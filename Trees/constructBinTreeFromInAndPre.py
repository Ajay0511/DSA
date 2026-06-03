"""
Given two integer Array preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
"""

def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        def helper(preorder, preStart,preEnd, inorder, inStart, inEnd, dic):
            if preStart > preEnd or inStart > inEnd :
                return None
            
            root = TreeNode(preorder[preStart])

            inRoot = dic[root.val]

            numsLeft = inRoot - inStart

            root.left = helper(preorder, preStart + 1, preStart+numsLeft , inorder, inStart, inRoot-1 , dic)
            root.right = helper(preorder, preStart + numsLeft + 1, preEnd , inorder, inRoot+1, inEnd , dic)
            return root
        
        dic = {}
        for i in range(len(inorder)):
            dic[inorder[i]] = i
        return helper(preorder,0,len(preorder)-1, inorder, 0 , len(inorder)-1,dic)
                                                                          

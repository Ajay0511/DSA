"""
Given a root of a Binary Tree, return its boundary traversal in the following order:

Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
"""


def printBoundaryView(self, root):
 
        # Code here
        if not root:
            return
        left = []
        right = []
        
        node = root.left
        while(node):
            if node.left or node.right:
                left.append(node)
            if node.left:
                node = node.left
            else:
                node = node.right
        
        node = root.right
        
        while(node):

            if node.left or node.right:
                right.append(node)
            if node.right:
                node = node.right
            else:
                node = node.left
        
        leaf_nodes = []
        def dfs(node):
            if not node:
                return
            # Check if it's a leaf node
            if not node.left and not node.right:
                leaf_nodes.append(node)
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        # print(leaf_nodes)
        ans = [root.data]
        for i in left:
            ans.append(i.data)
        for i in leaf_nodes:
            ans.append(i.data)
        for i in right[::-1]:
            ans.append(i.data)
        if not root.left and not root.right:
            ans = [root.data]
            
        return ans

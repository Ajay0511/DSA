"""
You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note:

Return the nodes from the leftmost node to the rightmost node.
If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 
Examples:

Input: root = [1, 2, 3]
Output: [2, 1, 3]
Explanation: The Green colored nodes represents the top view in the below Binary tree.
 
Input: root = [10, 20, 30, 40, 60, 90, 100]
Output: [40, 20, 10, 30, 100]
Explanation: The Green colored nodes represents the top view in the below Binary tree.


Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
"""

from collections import deque


def topView(root):
    if not root:
        return []

    top_view = {}  # Dictionary to store first node at each horizontal distance
    queue = deque([(root, 0)])  # Queue for BFS (node, horizontal distance)
    
    min_dist, max_dist = 0, 0  # Track leftmost and rightmost distances

    while queue:
        node, dist = queue.popleft()

        # Store first node at this horizontal distance
        if dist not in top_view:
            top_view[dist] = node.val

        # Track min/max horizontal distance
        min_dist = min(min_dist, dist)
        max_dist = max(max_dist, dist)

        # Add left and right children to queue
        if node.left:
            queue.append((node.left, dist - 1))
        if node.right:
            queue.append((node.right, dist + 1))

    # Extract values in order from min_dist to max_dist
    return [top_view[d] for d in range(min_dist, max_dist + 1)]
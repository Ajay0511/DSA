"""
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
"""

from typing import List
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # Add a 0 at the end to force all remaining bars to be popped
        heights.append(0)

        maxArea = 0
        st = []   # Stack will store indices of increasing heights

        for i, curr_height in enumerate(heights):

            # If current bar is smaller, rectangles must end here
            while st and heights[st[-1]] > curr_height:

                idx = st.pop()                  # index of bar whose rectangle is being closed
                prev_height = heights[idx]      # height of that bar

                # Find how wide this bar can extend
                # If stack is not empty, left boundary is st[-1] + 1
                # If empty, left boundary is 0
                width = i - st[-1] - 1 if st else i

                # Calculate area using this bar as the shortest height
                maxArea = max(prev_height * width, maxArea)

            # Push current bar index
            st.append(i)

        return maxArea

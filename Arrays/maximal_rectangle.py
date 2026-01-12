"""
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= rows, cols <= 200
matrix[i][j] is '0' or '1'.
"""

from typing import List

class Solution:

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        def largestHistogramRectangleArea(heights: List[int]) -> int:
            heights.append(0)
            maxArea = 0
            st = []   
            for i, curr_height in enumerate(heights):
                while st and heights[st[-1]] > curr_height:
                    idx = st.pop()                  
                    prev_height = heights[idx]      
                    width = i - st[-1] - 1 if st else i
                    maxArea = max(prev_height * width, maxArea)
                st.append(i)
            return maxArea
        
        maxArea = 0
        heights = [0] * (len(matrix[0]) + 1)
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if(matrix[i][j] == '1'):
                    heights[j] += int(matrix[i][j])
                else:
                    heights[j] = 0
            maxArea = max(maxArea, largestHistogramRectangleArea(heights))
        return maxArea
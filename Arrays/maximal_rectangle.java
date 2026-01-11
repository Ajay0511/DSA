package Arrays;
/*
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
*/

import java.util.*;
class Pair{
    int index;
    int height;
    public Pair(int index, int height){
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestHistogram(int[] histogram){
        int maxArea = 0;
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<histogram.length;i++){
            int curr_ind = i;
            int curr_height = histogram[i];
            while(!st.isEmpty() && st.peek().height > curr_height){
                Pair p = st.pop();
                maxArea = Math.max(p.height * (i-p.index), maxArea);
                curr_ind = p.index;
            }
            st.push(new Pair(curr_ind, curr_height));
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int maxx = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n+1];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    height[j] += 1;
                } else{
                    height[j] = 0;
                }
            }
            height[n] = 0;
            maxx = Math.max(maxx, largestHistogram(height));
        }
        return maxx;
    }
}
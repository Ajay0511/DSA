/*
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

 

Example 1:


Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.
Example 2:


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
 

Constraints:

n == matrix.length == matrix[i].length
2 <= n <= 250
-105 <= matrix[i][j] <= 105
*/

package Arrays;

class Solution {
    public long maxMatrixSum(int[][] matrix) {

        // Stores the sum of absolute values of all elements
        long res = 0;

        // Counts how many negative numbers are present in the matrix
        int neg_count = 0;

        // Tracks the smallest absolute value in the matrix
        // Used when one number must remain negative
        int mat_min = Integer.MAX_VALUE;

        // Traverse each element in the matrix
        for (int[] mat : matrix) {
            for (int n : mat) {

                // Add absolute value assuming all numbers can be made positive
                res += Math.abs(n);

                // Count negative numbers
                if (n < 0) {
                    neg_count += 1;
                }

                // Update minimum absolute value
                mat_min = Math.min(mat_min, Math.abs(n));
            }
        }

        /*
            If the number of negative elements is odd:
            - One element must remain negative (parity cannot change)
            - To minimize the loss, keep the smallest absolute value negative

            That value was added as +mat_min,
            but it should be -mat_min,
            so the net reduction is:
            (+mat_min) - (-mat_min) = 2 * mat_min
        */
        if ((neg_count & 1) == 1) {
            res -= (2 * mat_min);
        }

        return res;
    }
}

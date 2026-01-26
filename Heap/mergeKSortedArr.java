/*
You are given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order. Your task is to merge all the rows and return a single sorted array that contains all the elements of the matrix.

Examples :

Input: mat[][] = [[1, 3, 5, 7],
                [2, 4, 6, 8], 
                [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4], 
                [2, 2, 3, 4],
                [5, 5, 6, 6],
                [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] 
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Constraints:
1 ≤ n * m ≤ 105
1 ≤ mat[i][j] ≤ 106
*/
import java.util.*;
class Solution {
    static class Pair{
        int value;
        int row;
        int col;
        Pair(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y) -> x.value-y.value);
        ArrayList<Integer> aa = new ArrayList<>();
        for(int i=0;i<m;i++){
            minHeap.add(new Pair(mat[i][0],i,0));
        }
        
        while(!minHeap.isEmpty()){
            Pair curr = minHeap.poll();
            aa.add(curr.value);
            if(curr.col<n-1){
                minHeap.add(new Pair(mat[curr.row][curr.col+1], curr.row, curr.col+1));
            }
        }
     
        return aa;
    }
}
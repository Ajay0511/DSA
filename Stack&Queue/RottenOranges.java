/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1. 

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Pair{
        int row;
        int col;
        int count;
        public Pair(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public int orangesRotting(int[][] grid) {
        int maxx = 0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            maxx = Math.max(maxx, p.count);
            for(int k=0;k<4;k++){
                int r = p.row + dirs[k][0];
                int c = p.col + dirs[k][1];
                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 1){
                    grid[r][c] = 2;
                    queue.offer(new Pair(r,c,p.count+1));
                }
            }
        }

        for(int a=0;a<grid.length;a++){
            for(int b=0;b<grid[0].length;b++){
                if(grid[a][b] == 1){
                    return -1;
                }
            }
        }

        return maxx;
    }
}
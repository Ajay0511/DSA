/*
You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once. Return the top k maximum sum combinations, sorted in non-increasing order.

Examples:

Input: a[] = [3, 2], b[] = [1, 4], k = 2
Output: [7, 6]
Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.
Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
Output: [10, 9, 9]
Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9
Constraints:
1 ≤ a.size() = b.size() ≤ 105
1 ≤ k ≤ a.size()
1 ≤ a[i], b[i] ≤ 104

*/

import java.util.*;
class Solution {
    
    static class Pair{
        int sum;
        int i;
        int j;
        
        Pair(int sum, int i, int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (x,y) -> y.sum -x.sum);
        
        Set<String> visited = new HashSet<>();
        
        int n = a.length;
        
        int i =n-1;
        int j=n-1;
        maxHeap.add(new Pair(a[i]+b[j],i,j));
        visited.add(i + "," + j);
        while(k>0 && !maxHeap.isEmpty()){
            Pair curr = maxHeap.poll();
            ans.add(curr.sum);
            i = curr.i;
            j = curr.j;
            if(i-1>=0){
                String key = (i-1) + "," + j;
                if(!visited.contains(key)){
                    maxHeap.add(new Pair(a[i-1]+b[j],i-1,j));
                    visited.add(key);
                }
            }
            if(j-1>=0){
                String key = i + "," + (j-1);
                if(!visited.contains(key)){
                    maxHeap.add(new Pair(a[i]+b[j-1],i,j-1));
                    visited.add(key);
                }
            }
            k-=1;
        }
        return ans;
        
    }
}
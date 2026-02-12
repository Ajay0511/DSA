/*
You are given an integer array arr[ ]. For every element in the array, your task is to determine its Next Smaller Element (NSE).


The Next Smaller Element (NSE) of an element x is the first element that appears to the right of x in the array and is strictly smaller than x.

If no such element exists, assign -1 as the NSE for that position.
Examples:

Input: arr[] = [4, 8, 5, 2, 25]
Output: [2, 5, 2, -1, -1]
Explanation: 
The first element smaller than 4 having index > 0 is 2.
The first element smaller than 8 having index > 1 is 5.
The first element smaller than 5 having index > 2 is 2.
There are no elements smaller than 4 having index > 3.
There are no elements smaller than 4 having index > 4.
Input: arr[] = [13, 7, 6, 12]
Output: [7, 6, -1, -1]
Explanation:
The first element smaller than 13 having index > 0 is 7.
The first element smaller than 7 having index > 1 is 6.
There are no elements smaller than 6 having index > 2.
There are no elements smaller than 12 having index > 3.

Input: arr[] = [4, 1]
Output: [1, -1]
Explanation: 4 will be updated to 1 and 1 will be updated to -1.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
*/

import java.util.ArrayList; 
import java.util.Stack;
class Solution {
    static class Pair{
        private int ele;
        private int idx;
        public Pair(int ele, int idx){
            this.ele = ele;
            this.idx = idx;
        }
    }
        
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            while(!st.isEmpty() && st.peek().ele > arr[i]){
                Pair popped = st.pop();
                ans[popped.idx] = arr[i];
            }
            st.push(new Pair(arr[i], i));            
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int value : ans) {
            if(value == 0){
                value = -1;
            }
            arrayList.add(value);
        }
        return arrayList;
    }
        
}

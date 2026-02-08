/*
Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

Examples:

Input: st[] = [1, 2, 3]
Output: [3, 2, 1]
Explanation: The stack is already sorted in ascending order.

Input: st[] = [41, 3, 32, 2, 11]
Output: [41, 32, 11, 3, 2]
Explanation: After sorting, the smallest element (2) is at the bottom and the largest element (41) is at the top.

Constraints:
1 ≤ st.size() ≤ 103
0 ≤ stack element ≤ 103

*/

import java.util.Stack;
class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        Stack<Integer> helperSt = new Stack<>();
        while(!st.isEmpty()){
            int top = st.pop();
            if(helperSt.isEmpty()){
                helperSt.push(top);
            } else{
                while(!helperSt.isEmpty() && top > helperSt.peek()){
                    int b = helperSt.pop();
                    st.push(b);
                }
                helperSt.push(top);
            }
        }
        while(!helperSt.isEmpty()){
            st.push(helperSt.pop());
        }
    }
}
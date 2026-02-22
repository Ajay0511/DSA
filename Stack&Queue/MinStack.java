/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

import java.util.Stack;

class SpecialStack {
    Stack<Integer> minStack;
    Stack<Integer> st;
    
    public SpecialStack() {
        // Define Stack
        this.st = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        st.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        // Remove the top element from the Stack
        if(st.isEmpty()){
            return;
        }
        int ele = st.pop();
        if(ele == minStack.peek()){
            minStack.pop();
        }
        
    }

    public int peek() {
        // Returns top element of the Stack
        if(!st.isEmpty()){
            return st.peek();   
        }
        return -1;
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}
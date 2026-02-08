"""
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
"""
def insert(stack,temp):
    if len(stack)==0 or stack[-1] <= temp:
        stack.append(temp)
        return 
    
    val = stack.pop()
    insert(stack,temp)
    stack.append(val)

def sortStack(stack):
    # given data structure is a python list 
    # as list have all the similar operations available so use them
    # Write your code here
    
    if len(stack) == 0:
        return 
    
    temp = stack[-1]
    stack.pop()
    sortStack(stack)
    insert(stack,temp)


"""
Problem statement
You are given an array of ‘N’ integers, you need to find the maximum of minimum for every window size. The size of the window should vary from 1 to ‘N’ only.

For example:

ARR = [1,2,3,4]
Minimums of window size 1 = min(1), min(2), min(3), min(4) = 1,2,3,4
Maximum among (1,2,3,4)  is 4

Minimums of window size 2 = min(1,2), min(2,3),   min(3,4) = 1,2,3
Maximum among (1,2,3) is 3

Minimums of window size 3 = min(1,2,3), min(2,3,4) = 1,2
Maximum among (1,2) is 2

Minimums of window size 4 = min(1,2,3,4) = 1
Maximum among them is 1
The output array should be [4,3,2,1].
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 10 ^ 4 
-10 ^ 9 <= ARR[i] <= 10 ^ 9

Where ‘T’ is the number of test cases, ‘N’ is the size of the array and ‘ARR[i]’ is the size of the array elements.

Time Limit: 1 sec
Sample Input 1:
2
4
1 2 3 4
5
3 3 4 2 4    
Sample Output 1:
4 3 2 1
4 3 3 2 2
Explanation for sample input 1:
Test case 1:
Already explained in the question.

Test case 2:
Minimums of window size 1 = min(3), min(3), min(4), min(2), min(4) = 3, 3, 4, 2, 4
Maximum among (3, 3, 4, 2, 4) is 4

Minimums of window size 2 = min(3,3), min(3,4), min(4,2), min(2,4) = 3, 3, 2, 2
Maximum among (3, 3, 2, 2) is 3

Minimums of window size 3 = min(3,3,4), min(3,4,2), min(4,2,4) = 3, 2, 2
Maximum among (3, 2, 2) is 3

Minimums of window size 4 = min(3,3,4,2), min(3,4,2,4) = 2, 2
Maximum among (2, 2) is 2

Minimums of window size 4 = min(3,3,4,2,4) = 2
Maximum among them is 2
The output array should be [4,3,3,2,2].
Sample Input 2:
2
5 
45 -2 42 5 -11 
6 
-2 12 -1 1 20 1 
Sample Output 2:
 45 5 -2 -2 -11
 20 1  1 -1 -1 -2
"""
def maxMinWindow(arr, n):
    result = [-99999999999999] * n
    left_min = [0] * n
    right_min = [0] * n
    stack = []


    # Find nearest minimum element on the left for each element

    for i in range(n):
        while stack and arr[i] <= arr[stack[-1]]:
            stack.pop()
        left_min[i] = stack[-1] if stack else -1
        stack.append(i)

    stack = []

     # Find nearest minimum element on the right for each element
    for i in range(n - 1, -1, -1):

        while stack and arr[i] <= arr[stack[-1]]:
            stack.pop()
        right_min[i] = stack[-1] if stack else n
        stack.append(i)
 
    # Calculate the maximum of minimum values for each window size

    for i in range(n):
        window_size = right_min[i] - left_min[i] - 1
        result[window_size - 1] = max(result[window_size - 1], arr[i])

    # Fill in any missing values in the result list
    for i in range(n - 2, -1, -1):
        result[i] = max(result[i], result[i + 1])
    return result

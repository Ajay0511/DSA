"""
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                [0, 1, 0],
                [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.
Input: mat[][] = [[1, 1], 
                [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.
Input: mat[][] = [[1]]
Output: 0
Constraints:
1 ≤ mat.size() ≤ 1000
0 ≤ mat[i][j] ≤ 1
mat[i][i] = 1
"""
def findCelebrity(n, knows):

    # Write your code here.    
    st = []
    for i in range(n):
        st.append(i)
    
    while(len(st)>1):
        a = st.pop()
        b = st.pop()
        if(knows(a,b)):
            st.append(b)
        else:
            st.append(a)

    
    for i in range(n):
        if i != st[-1]:
            if(not knows(i,st[-1])):
                return -1
            if(knows(st[-1],i)):
                return -1
    return st[-1]

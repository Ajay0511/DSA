"""
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

"""

def solve(self, A, B, C):
    A.sort(reverse = True)
    B.sort(reverse=True)
    from heapq import heappush,heappop
    
    
    i = 0
    j = 0
    lis = []
    ans = []
    n = len(A)
    st = set()
    heappush(lis,[-(A[i]+B[j]),(0,0)])
    st.add((0,0))
    while(C>0):
        top = heappop(lis)
        ans.append(top[0]*-1)
        i = top[1][0]
        j = top[1][1]
        if(i<n and j<n):
            if((i+1,j) not in st):
                heappush(lis,[-(A[i+1]+B[j]),(i+1,j)])
                st.add((i+1,j))
            if((i,j+1) not in st):
                heappush(lis,[-(A[i]+B[j+1]),(i,j+1)])
                st.add((i,j+1))
        C-=1
    return ans
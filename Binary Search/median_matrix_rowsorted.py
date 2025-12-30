

"""
    def median(matrix: [[int]], m: int, n: int) -> int:
        # Write your code here.
        arr = []
        for i in range(m):
            for j in range(n):
                arr.append(matrix[i][j])
        arr.sort()
        return arr[len(arr)//2]
        pass
"""

from bisect import bisect_right

def median(matrix, m, n):

    low = min(row[0] for row in matrix)
    high = max(row[-1] for row in matrix)

    req = (m * n) // 2

    while low <= high:
        mid = (low + high) // 2

        count = 0
        for row in matrix:
            count += bisect_right(row, mid)

        if count <= req:
            low = mid + 1
        else:
            high = mid - 1

    return low

"""
You are given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order. Your task is to merge all the rows and return a single sorted array that contains all the elements of the matrix.

Examples :

Input: mat[][] = [[1, 3, 5, 7],
                [2, 4, 6, 8], 
                [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4], 
                [2, 2, 3, 4],
                [5, 5, 6, 6],
                [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] 
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Constraints:
1 ≤ n * m ≤ 105
1 ≤ mat[i][j] ≤ 106
"""
def mergeKSortedArray(kArray, k: int):
    from heapq import heappush, heappop

    minHeap = []
    result = []

    # push first element of each array
    for i in range(k):
        if len(kArray[i]) > 0:
            heappush(minHeap, (kArray[i][0], i, 0))
            # (value, array_index, element_index)

    while minHeap:
        val, arr_idx, ele_idx = heappop(minHeap)
        result.append(val)

        # push next element from same array
        if ele_idx + 1 < len(kArray[arr_idx]):
            heappush(
                minHeap,
                (kArray[arr_idx][ele_idx + 1], arr_idx, ele_idx + 1)
            )

    return result

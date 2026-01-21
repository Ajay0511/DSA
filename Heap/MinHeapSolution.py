"""
Problem statement
Implement the Min Heap data structure.

You will be given 2 types of queries:-

0 X
Insert X in the heap.

1
Print the minimum element from the heap and remove it.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 5
1 <= N <= 10^5
1 <= X <= 50

Time Limit: 1 sec
Sample Input 1 :
2
3
0 2
0 1
1
2
0 1
1
Sample Output 1 :
1
1
Explanation Of Sample Input 1 :
For the first test case:-
Insert 2 in the heap and currently, 2 is the smallest element in the heap.
Insert 1 in the heap and now the smallest element is 1.
Return and remove the smallest element which is 1.

For the second test case:-
Insert 1 in the heap and currently, 1 is the smallest element in the heap.
Return the smallest element from the heap which is 1 and remove it.
Sample Input 2 :
2
5
0 5
1
0 43
0 15
0 5
2
0 4
1
Sample Output 2 :
5
4
"""


from sys import *

class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def left_child(self, i):
        return 2 * i + 1

    def right_child(self, i):
        return 2 * i + 2

    def insert(self, x):
        self.heap.append(x)
        self.heapify_up(len(self.heap) - 1)

    def extract_min(self):
        if len(self.heap) == 0:
            return -1
        min_val = self.heap[0]
        self.heap[0] = self.heap[-1]
        self.heap.pop()
        self.heapify_down(0)
        return min_val

    def heapify_up(self, i):
        while i > 0 and self.heap[self.parent(i)] > self.heap[i]:
            self.swap(i, self.parent(i))
            i = self.parent(i)

    def heapify_down(self, i):
        while True:
            min_index = i
            left = self.left_child(i)
            right = self.right_child(i)

            if left < len(self.heap) and self.heap[left] < self.heap[min_index]:
                min_index = left

            if right < len(self.heap) and self.heap[right] < self.heap[min_index]:
                min_index = right

            if i != min_index:
                self.swap(i, min_index)
                i = min_index
            else:
                break

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]




def minHeap(N: int, Q: [[]]) -> []:
    heap = MinHeap()
    result = []

    for query in Q:
        if query[0] == 0:
            heap.insert(query[1])
        elif query[0] == 1:
            min_ele = heap.extract_min()
            if min_ele is not None:
                result.append(min_ele)
    return result
    

    # Write your code frome here.
    pass


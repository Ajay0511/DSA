package Heap;
/*
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
*/

import java.util.* ;
import java.io.*; 

public class MinHeapSolution {

    static class MinHeap{
        ArrayList<Integer> heap = new ArrayList<>();

        int parent(int i){
            return (i-1)/2;
        }

        int left_child(int i){
            return 2*i + 1;
        }

        int right_child(int i){
            return 2*i+2;
        }

        void insert(int x){
            heap.add(x);
            heapifyUp(heap.size()-1);
        }

        void heapifyUp(int i){
            while(i>0 && heap.get(parent(i)) > heap.get(i)){
                swap(i, parent(i));
                i = parent(i);
            }
        }

        void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        int extractMin(){                   
            if(heap.size() == 0){
                return -1;
            }
            int min = heap.get(0);
            int last = heap.get(heap.size()-1);
            heap.set(0, last);
            heap.remove(heap.size()-1);
            heapifyDown(0);
            return min;
        }

        void heapifyDown(int i){
            int size = heap.size();
            while(true){
                int minindex = i;
                int left = left_child(i);
                int right = right_child(i);
                if(left < size && heap.get(left) < heap.get(minindex)){
                    minindex = left;
                }
                if(right < size && heap.get(right) < heap.get(minindex)){
                    minindex = right;
                }
                if(i!=minindex){
                    swap(minindex, i);
                    i = minindex;
                } else{
                    break;
                }
            }
        }
    }

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        MinHeap minheap = new MinHeap();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(q[i][0] == 0){
                minheap.insert(q[i][1]);
            } else if(q[i][0] == 1){
                result.add(minheap.extractMin());
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;



    }
}
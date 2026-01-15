/*
 * "Given two sorted Array arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.


Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the Array arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))"
*/
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        if(a.length > b.length){
            return kthElement( b, a, k);
        }
        
        
        int n = a.length;
        int m = b.length;
        
        // x + y = k
        // y <= m  ⇒ k - x <= m ⇒ x >= k - m
        // x >= 0
        int low = Math.max(k-m,0);
        
        // x <= k
        // x <= n
        int high = Math.min(k,n);
        
        while(low<=high){
            int cutA = low + (high-low)/2;
            int cutB = k-cutA;
            
            int l1 = (cutA==0) ? Integer.MIN_VALUE : a[cutA-1];
            int r1 = (cutA==n) ? Integer.MAX_VALUE : a[cutA];
            int l2 = (cutB==0) ? Integer.MIN_VALUE : b[cutB-1];
            int r2 = (cutB==m) ? Integer.MAX_VALUE : b[cutB];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            } else if(l1>r2){
                high = cutA-1;
            } else{
                low = cutA+1;
            }
            
        }
        return -1;
        
        
    }
}

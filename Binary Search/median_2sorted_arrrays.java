/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //  Always binary-search on the smaller array
        // This guarantees O(log(min(n1, n2))) time
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] A = nums1;   // smaller array
        int[] B = nums2;   // larger array

        int n1 = A.length;
        int n2 = B.length;

        // 2️⃣ Total number of elements
        int total = n1 + n2;

        // 3️⃣ Number of elements that must be in the LEFT half
        // +1 ensures LEFT gets the extra element when total is odd
        int left = (total + 1) / 2;

        // 4️⃣ Binary search range:
        // mid1 = how many elements we take from A into LEFT half
        int low = 0;
        int high = n1;

        while (low <= high) {

            // 5️⃣ Try taking mid1 elements from A, mid1 are counts of element
            int mid1 = (low + high) / 2;

            // Remaining elements needed for LEFT half come from B, mid2 is count of elements
            int mid2 = left - mid1;

            // 6️⃣ Border elements around the partition
            // l1, r1 → left/right borders in A
            // l2, r2 → left/right borders in B

            int l1 = (mid1 > 0) ? A[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? A[mid1]     : Integer.MAX_VALUE;

            int l2 = (mid2 > 0) ? B[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? B[mid2]     : Integer.MAX_VALUE;

            // 7️⃣ Check if we found the correct partition
            // All elements on LEFT must be <= all elements on RIGHT
            if (l1 <= r2 && l2 <= r1) {

                // 8️⃣ If total length is odd, median is max of LEFT
                if (total % 2 == 1) {
                    return Math.max(l1, l2);
                }
                // 9️⃣ If total length is even, median is average of middle two
                else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }

            // 10️⃣ If we took too many elements from A, move left
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // 11️⃣ If we took too few elements from A, move right
            else {
                low = mid1 + 1;
            }
        }

        // This line is never reached if input arrays are sorted
        return 0.0;
    }
}

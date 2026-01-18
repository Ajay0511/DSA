/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 103
*/

class Solution {

    // Function to check if it is possible to allocate books
    // such that no student reads more than 'maxPages'
    // and the total number of students used is <= k
    public boolean bookAllocationPossible(int k, int maxPages, int[] arr) {
        int totalStudent = 1; // start with the first student
        int curr = 0;         // pages assigned to current student

        for (int i = 0; i < arr.length; i++) {
            // If adding this book does not exceed maxPages, give it to current student
            if (curr + arr[i] <= maxPages) {
                curr += arr[i];
            } else {
                // Otherwise, allocate this book to a new student
                totalStudent += 1;
                curr = arr[i]; // current book becomes first book of new student
            }

            // If at any point students exceed k, allocation is not possible
            if (totalStudent > k) {
                return false;
            }
        }

        // Allocation successful using <= k students
        return true;
    }

    // Function to find the minimum possible value of the maximum pages
    // any student has to read
    public int findPages(int[] arr, int k) {
        // If students > number of books, allocation is impossible
        if (k > arr.length) {
            return -1;
        }

        int pagesSum = 0;      // sum of all book pages
        int low = Integer.MIN_VALUE; // minimum possible maximum pages

        // Calculate low (max single book) and total pages
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]); // max pages in a single book
            pagesSum += arr[i];          // sum of all pages
        }

        int high = pagesSum; // maximum possible maximum pages (one student reads all)
        int ans = high;      // store the best answer found

        // Binary search to find minimum possible maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate max pages

            // Check if allocation is possible with mid as max pages
            if (bookAllocationPossible(k, mid, arr)) {
                ans = mid;        // update answer
                high = mid - 1;   // try to find a smaller max pages
            } else {
                low = mid + 1;    // mid too small, need more pages
            }
        }

        return ans; // minimum possible maximum pages
    }
}

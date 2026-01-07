package Arrays;

/*
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.

 

Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation: 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
Example 2:

Input: nums = [21,21]
Output: 64
Example 3:

Input: nums = [1,2,3,4,5]
Output: 0
 

Constraints:

1 <= nums.length <= 104
1 <= nums[i] <= 105
*/
class Solution {

    // Check if a number is prime
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Returns sum of divisors if exactly 4 divisors exist, else 0
    private int checkIfFourDivisor(int n) {

        // Case 1: n = p^3
        int root = (int) Math.round(Math.cbrt(n));
        if (root * root * root == n && isPrime(root)) {
            return 1 + root + root * root + n;
        }

        // Case 2: n = p * q (p ≠ q, both prime)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;
                if (i != j && isPrime(i) && isPrime(j)) {
                    return 1 + i + j + n;
                }
                return 0; // no other valid divisor possible
            }
        }

        return 0;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += checkIfFourDivisor(num);
        }
        return sum;
    }
}

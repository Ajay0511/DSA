/* 
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.
*/


class Solution {
    public int[] singleNumber(int[] nums) {

        // Step 1: XOR all numbers
        // All duplicate numbers cancel out (x ^ x = 0)
        // Result will be XOR of the two unique numbers: a ^ b
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a bit where the two unique numbers differ
        // xor & -xor isolates the rightmost set bit of (a ^ b)
        // This bit is guaranteed to be different in the two unique numbers
        int different_bit = xor & (-xor);

        // Step 3: Divide numbers into two groups based on the different bit
        // One unique number goes into group1, the other into group2
        int group1_num = 0;
        int group2_num = 0;

        for (int num : nums) {
            // If the different bit is NOT set, go to group1
            if ((num & different_bit) == 0) {
                group1_num ^= num;  // duplicates cancel out
            } 
            // If the different bit IS set, go to group2
            else {
                group2_num ^= num;  // duplicates cancel out
            }
        }

        // Step 4: group1_num and group2_num now contain the two unique numbers
        return new int[]{group1_num, group2_num};
    }
}

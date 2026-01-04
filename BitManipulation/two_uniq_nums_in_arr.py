"""Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
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
Each integer in nums will appear twice, only two integers will appear once."""


from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:

        # Step 1: XOR all numbers
        # Duplicate numbers cancel out because x ^ x = 0
        # Result will be XOR of the two unique numbers: a ^ b
        xor = 0
        for num in nums:
            xor ^= num

        # Step 2: Find the rightmost set bit in (a ^ b)
        # This bit is guaranteed to be different in the two unique numbers
        # Because XOR sets a bit only when two bits differ
        different_bit = xor & -xor

        # Step 3: Split numbers into two groups using the different bit
        # One unique number will fall in each group
        group1 = 0
        group2 = 0

        for num in nums:
            # If the bit is not set, place number in group1
            if (num & different_bit) == 0:
                group1 ^= num  # duplicates cancel out
            # If the bit is set, place number in group2
            else:
                group2 ^= num  # duplicates cancel out

        # Step 4: The two groups contain the two unique numbers
        return [group1, group2]

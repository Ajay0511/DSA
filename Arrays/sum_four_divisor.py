"""
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
"""

import math
class Solution:
    def prime(self,n):
        if(n<2):
            return False
        for i in range(2,round(n**0.5) + 1):
            if(n%i == 0):
                return False
        return True
    def checkIfFourDivisor(self,n):
        root = round(n**(1/3))
        if(root**3 == n and self.prime(root)):
            return 1 + n + root + root**2


        cnt = 0
        for i in range(2,round(n**1/2)+1):
            if(n%i == 0):
                j = n//i
                if(i!=j and self.prime(i) and self.prime(j)):
                    return 1+i+j+n
                return 0
        return 0

                

    def sumFourDivisors(self, nums: List[int]) -> int:
        summ = 0
        for num in nums:
            summ+= self.checkIfFourDivisor(num)
        return summ
            
        
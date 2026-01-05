"""
    You are given an integer array nums with the following properties:

    nums.length == 2 * n.
    nums contains n + 1 unique elements.
    Exactly one element of nums is repeated n times.
    Return the element that is repeated n times.

    

    Example 1:

    Input: nums = [1,2,3,3]
    Output: 3
    Example 2:

    Input: nums = [2,1,2,5,3,2]
    Output: 2
    Example 3:

    Input: nums = [5,1,5,2,5,3,5,4]
    Output: 5
    

    Constraints:

    2 <= n <= 5000
    nums.length == 2 * n
    0 <= nums[i] <= 104
    nums contains n + 1 unique elements and one of them is repeated exactly n times.

"""

class Solution:
    def repeatedNTimes(self, arr: List[int]) -> int:
        """
            Problem idea:
            Array size = 2N
            Exactly one element is repeated N times
            All other elements appear only once

            Key observation (Pigeonhole Principle):
            Since one number appears N times, it must appear
            at least twice within any window of 3 consecutive elements.
        """
        n = len(arr)
        # Traverse till n-2 so that i+1 and i+2 are always valid indices
        for i in range(n-2):
            """
                Check two cases:
                1) Current element equals next element
                2) Current element equals element after next

                If either is true, this element is the repeated one
            """
            if(arr[i] == arr[i+1] or arr[i] == arr[i+2]):
                return arr[i]
            
            """
                If not found in the loop, then the repeated element
                must be at the last position
                (edge case handling)
            """
        return arr[-1]


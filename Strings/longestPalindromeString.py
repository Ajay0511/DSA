
"""
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
"""

def longestPalindrome(self, s: str) -> str:
    temp = ''
    def helper(s,i,j):
        while(i>=0 and j<len(s) and s[i]==s[j]):
            i-=1
            j+=1
        return s[i+1:j]
    
    for i in range(len(s)):
        res = helper(s,i,i)
        if len(res) > len(temp) :
            temp = res
    
    for i in range(len(s)-1):
        res = helper(s,i,i+1)
        if len(res) > len(temp) :
            temp = res
    return temp
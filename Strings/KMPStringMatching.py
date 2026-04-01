"""
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.


Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
"""

def strStr(self, haystack: str, needle: str) -> int:

        def calculateLps(s):
            n = len(s)
            lps = [0 for i in range(n)]
            prevlps = 0
            i = 1
            while(i<n):
                if s[i] == s[prevlps]:      #strings equal, put prevlps+1 in lps[i]
                    lps[i] = 1+prevlps
                    prevlps+=1
                    i+=1
                elif prevlps == 0:               #strings unequal and prevlps = 0 then lps[i] = 0
                    lps[i] = 0
                    i+=1
                else:         #strings unequal but prevlps has value then prevlps = lps[prevlps-1]
                    prevlps = lps[prevlps-1]
            return lps
        
        lps_arr = calculateLps(needle)
        i = 0
        j = 0
        while(i<len(haystack)):
            if haystack[i] == needle[j]:
                i+=1
                j+=1
            else:
                if j == 0:
                    i+=1
                else:
                    j = lps_arr[j-1]

            if j == len(needle):
                return i-len(needle) #because we moved forward with each successful match
        return -1

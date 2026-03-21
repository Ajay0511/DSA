"""
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.
 
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
"""

from typing import List
def longestCommonPrefix(self, strs: List[str]) -> str:
    s = strs[0]
    pre  = ''
    for i in range(1,len(s)+1):
        break_outer = False
        temp_pre = s[:i]
        for j in range(1,len(strs)):
            if temp_pre != strs[j][:i]:
                break_outer = True
                break
        if(break_outer):
            break
        pre = temp_pre
    return pre
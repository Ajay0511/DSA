"""
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
"""

class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i in range(len(s)):
            # print(st)
            if not st:
                st.append(s[i])
            elif st[-1] == '{' and s[i] == '}':
                st.pop()
            elif st[-1] == '(' and s[i] == ')':
                st.pop()
            elif st[-1] == '[' and s[i] == ']':
                st.pop()
            else:
                st.append(s[i])
        return len(st) == 0
            

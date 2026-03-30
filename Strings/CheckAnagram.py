"""
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
"""
def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    mp = {}
    for ch in s:
        mp[ch] = mp.get(ch, 0) + 1

    for ch in t:
        if ch not in mp:
            return False
        mp[ch] -= 1
        if mp[ch] == 0:
            del mp[ch]

    return len(mp) == 0

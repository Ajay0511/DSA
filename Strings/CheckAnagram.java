/*
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
*/

import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch, 0) + 1);
        }

        for(char chh : t.toCharArray()){
            
            if(mp.containsKey(chh)){
                int g = mp.get(chh);
                if(g == 1){
                    mp.remove(chh);
                } else{
                    mp.put(chh, g-1);
                }
            } else{
                return false;
            }
        }
        return mp.size() == 0;
    }
}

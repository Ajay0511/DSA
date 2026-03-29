/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2
 
Constraints:
1 <= a.length, b.length <= 104
a and b consist of lowercase English letters.
*/

import java.util.*;
class Solution {
    public int repeatedStringMatch(String a, String b) {
        HashSet<Character> setA = new HashSet<>();
        for(char ch : a.toCharArray()){
            setA.add(ch);
        }
        for(char ch : b.toCharArray()){
            if(!setA.contains(ch)){
                return -1;
            }
        }
        int count = 0;
        StringBuilder repeated = new StringBuilder();
        for (int i = 1; i <= (b.length() / a.length()) + 3; i++) {
            repeated.append(a);
            if (repeated.toString().contains(b)) return i;
        }
        return -1;
    }
}

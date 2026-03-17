/*
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
*/

class Solution {
    public String expandAroundCentre(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l-=1;
            r+=1;
        }
        return s.substring(l+1,r);
    }
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0;i<s.length();i++){
            String odd = expandAroundCentre(s,i,i);
            String even = expandAroundCentre(s,i,i+1);
            if(res.length()<odd.length()){
                res = odd;
            }
            if(res.length()<even.length()){
                res = even;
            }
        }
        return res;

    }
}
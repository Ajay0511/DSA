/*
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
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps_arr = calculateLps(needle);
        int i = 0;
        int j = 0;
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i+=1;
                j+=1;
            } else{
                if(j==0){
                    i+=1;
                } else{
                    j = lps_arr[j-1];
                }
            }
            if(j == needle.length()){
                return i - needle.length();
            }
        }
        return -1;
    }

    public int[] calculateLps(String s){
        int s_len = s.length();
        int[] lps = new int[s_len];
        int prevlps = 0;
        int i =1;
        while(i < s_len){
            if(s.charAt(i) == s.charAt(prevlps)){
                lps[i] = 1 + prevlps;
                i+=1;
                prevlps+=1;
            }
            else if(prevlps == 0){
                lps[i] = 0;
                i+=1;
            } else{
                prevlps = lps[prevlps - 1];
            }
        }
        return lps;
    }
}



/*
class Solution {
    
    int[] calculateLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 1;
        int prevLps = 0;
        while(i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(prevLps)){
                lps[i] = 1+prevLps;
                i+=1;
                prevLps+=1;
            } else if(prevLps == 0){
                lps[i] = 0;
                i+=1;
            } else {
                prevLps = lps[prevLps-1];
            }
        }
        return lps;
    }
    
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        int i = 0;
        int j = 0;
        int[] lps_arr = calculateLPS(pat);
        ArrayList<Integer> res = new ArrayList<>();
        while(i<txt.length()){
            if(pat.charAt(j) == txt.charAt(i)){
                i+=1;
                j+=1;
            } 
            if(j==pat.length()){
                res.add(i-pat.length());
                j = lps_arr[j-1];
            }
            else if(i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
                if(j == 0){
                    i+=1;
                } else{
                    j = lps_arr[j-1];
                }
            }
        }
        return res;
        
    }
}
*/

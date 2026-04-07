/*
Problem Description
 
Given a string A. The only operation allowed is to insert characters at the beginning of the string.
Find how many minimum characters are needed to be inserted to make the string a palindrome string.

Problem Constraints
1 <= |A| <= 106

Input Format
The only argument given is string A.

Output Format
Return the minimum characters that are needed to be inserted to make the string a palindrome string.

Example Input
Input 1:
A = "ABC"
Input 2:
A = "AACECAAAA"

Example Output
Output 1:
2
Output 2:
2

Example Explanation
Explanation 1:
Insert 'B' at beginning, string becomes: "BABC".
Insert 'C' at beginning, string becomes: "CBABC".
Explanation 2:
Insert 'A' at beginning, string becomes: "AAACECAAAA".
Insert 'A' at beginning, string becomes: "AAAACECAAAA".

*/

public class MinCharsToMakeStringPalindromic {
    private int[] computeLps(String s){
        int n = s.length();
        int[] lps = new int[n];
        int i =1;
        int prevlps=0;
        while(i<n){
            if(s.charAt(i) == s.charAt(prevlps)){
                lps[i] = 1 + prevlps;
                i+=1;
                prevlps+=1;
            } else if(prevlps == 0){
                lps[i] = 0;
                i+=1;
            } else{
                prevlps = lps[prevlps-1];
            }
        }
        return lps;
    }
    public int solve(String A) {
        String reversed = new StringBuilder(A).reverse().toString();
        String newStr = A + "$" + reversed;
        int[] l = computeLps(newStr);
        return A.length() - l[l.length-1]; 
    }
}

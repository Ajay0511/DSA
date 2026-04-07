"""
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
"""
class Solution:
    # @param A : string
    # @return an integer
    def solve(self, A):
        # if A == A[::-1]:
        #     return 0
        
        def calculateLps(s):
            i = 1
            prevlps = 0
            n = len(s)
            lps = [0]*n
            while(i<n):
                if s[i] == s[prevlps]:
                    lps[i] = 1+prevlps
                    i+=1
                    prevlps+=1
                elif prevlps == 0:
                    lps[i] = 0
                    i+=1
                else:
                    prevlps = lps[prevlps-1]
            return lps
        
        new_s = A + '$' + A[::-1]
        lps_arr = calculateLps(new_s)
        print(lps_arr)
        return len(A) - lps_arr[-1]
        
    
        
        

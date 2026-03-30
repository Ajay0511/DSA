"""
You’re given two strings, 'text' of length 'n' and 'pattern' of length 'm', consisting of lowercase characters.

Find all the occurrences of the string ‘pattern’ in ‘text’.

For each occurrence, print the index from where it starts in the string ‘text’ (1 - indexed).

Example:
Input: ‘text’ = “cxyzghxyzvjkxyz” and ‘pattern’ = “xyz”

Output: Occurrences = [2, 7, 13]

Explanation: The pattern ‘pattern’ = “xyz” appears at 3 positions in ‘text’.
Detailed explanation ( Input/output format, Notes, Images )

Sample Input 1:
cxyzghxyzvjkxyz
xyz

Sample Output 1:
3
2 7 13
Explanation Of Sample Input 1 :
The pattern ‘pattern’ = “xyz” appears at 3 positions in ‘text’.

Sample Input 2 :
ababacabab
aba

Sample Output 2 :
3
1 3 7
Explanation Of Sample Input 2 :
Here we have an overlap between the first occurrence (at position 1) and the second occurrence (at position 3), and we are considering both.

Sample Input 3 :
abcd
xy

Sample Output 3 :
0

Expected time complexity:
The expected time complexity is O(n + m).


Constraints:
1 <= ‘n’ <= 10 ^ 5
1 <= ‘m’ <= ‘n’
"""

def stringMatch(text: str, pattern: str) -> List[int]:
    # Write your code here.
    ans = []
    
    def calculateHash(string):
        prime = 101
        h = 0

        for char in string:
            h = (h*prime + ord(char))%pow(2,64)
        return h
    
    pat_hash = calculateHash(pattern)
    text_hash = calculateHash(text[:len(pattern)])


    for i in range(len(text)- len(pattern) + 1):
        if pat_hash == text_hash and pattern == text[i:i+len(pattern)]:
            ans.append(i+1)
    
        if i<len(text) - len(pattern):
            text_hash = (text_hash * 101 + ord(text[i+len(pattern)]) - ord(text[i]) * (101 ** len(pattern))) % 2**64
    
    return ans

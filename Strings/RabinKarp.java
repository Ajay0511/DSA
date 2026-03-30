/*
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
*/
import java.util.List;
import java.util.ArrayList;
public class Solution {
    static long calculateHash(String s){
        long prime = 101;
        long h = 0;
        for(char ch : s.toCharArray()){
            h = h*101 + ch;
        }
        return h;
    }

    static long power(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static List< Integer > stringMatch(String text, String pattern) {
        // Write your code here.
        List<Integer> lis = new ArrayList<>();
        long pattern_hash = calculateHash(pattern);
        int n = text.length();
        int m = pattern.length();
        long text_hash = calculateHash(text.substring(0,m));
        long highestPower = power(101, m);
        


        for(int i =0;i<=n-m;i++){
            if(pattern_hash == text_hash && pattern.equals(text.substring(i,i+m))){
                lis.add(i+1);
            }
            if(i<n-m){
                text_hash = (text_hash * 101) + text.charAt(i+m) - text.charAt(i) * highestPower;
            }
        }
        return lis;
        
    }
}

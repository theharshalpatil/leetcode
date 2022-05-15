/** (1)
 * Brute Force method; Exceeds time limit on Leetcode
 * TC: O(n^3)
 * SC: O(1)
 */
 class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int ansLen = 0, start = 0, end = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (checkPalindrome(s.substring(i, j+1)))
                    if (ansLen < j - i + 1) {
                        ansLen = j - i + 1;
                        start = i;
                        end = j;
                    }
            }
        }
        
        return s.substring(start, end+1);
    }
    
    public boolean checkPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}

/** (2)
 * Sliding window method: Accepted on Leetcode but really bad time and space consumption
 * Same as Brute Force with only change is condition that
 * start the next ith iteration window directly with size of ansLen
 * TC: O(n^3)
 * SC: O(1)
 */
  class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int ansLen = 0, start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + end - start; j < len; j++) {
                if (checkPalindrome(s.substring(i, j+1)))
                    if (ansLen < j - i + 1) {
                        ansLen = j - i + 1;
                        start = i;
                        end = j;
                    }
            }
        }
        return s.substring(start, end+1);
    }
    public boolean checkPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}

/**(3)
 * Dynamic Programming Approach
 * Maintain a matrix where (i, j)th index tells if substring(i, j) is a palindrome
 * Find if substring(i, j) is palindrome if (matrix[i+1][j-1]==true and s[i]==s[j]) comparing corner chars and mid-string
 * Build the table with all (i, j) where i==j as 'true' (string of len 1 are palindrome) // term case 1
 * Look at len 2 as well and fill all vals in matrix where abs(i-j)==1 [eg. i=2, j=3: i+1=3 and j-1=2 is not a mid-string]
 * for len(string) > 2, we'll find a substring for which palindrome check is already performed and results are in matrix
 * TC: O(n^2)
 * SC: O(n^2)
 */
 class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean matrix[][] = new boolean[len][len];
        int ansLen = 1; // s.length > 1 (given)
        int start = 0; // starting index. return s.charAt(0) for ansLen==1
        
        // fill 'true' for len==1 strings
        for (int i = 0; i < len; i++) matrix[i][i] = true;
        
        // find palindromes for len==2 strings
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                matrix[i][i+1] = true;
                start = i;
                ansLen = 2;
            }
        }
        
        // for len>2. 'k' as len of temp substring
        for (int k = 3; k <= len; k++) {
            // for starting indices
            for (int i = 0; i < len-k+1; i++) {
                int j = i + k - 1; // such that len==k
                if (matrix[i+1][j-1] && s.charAt(i)==s.charAt(j)) {
                    matrix[i][j] = true;
                    if (k > ansLen) {
                        ansLen = k;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + ansLen);
    }
}

/**(4)
 * Fix a center and expand in both directions and maintain longest seen palindrome
 * i=center; lower low until s[low]==s[i]; higher high until s[high]==s[i]; // since string with one unique char is always palindorme
 * expand further until s[low]==s[high]. Update LPS if found substring is longer than prev substring
 * TC: O(n^2)
 * SC: O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s; // ""/single charater always palindrome
        
        int ansLen = 1, start = 0;
        int low, high;
        
        for (int i = 0; i < len; i++) {
            low = i-1;
            high = i+1;
            
            while (low >= 0 && s.charAt(i) == s.charAt(low))
                low--;
            
            while (high < len && s.charAt(i) == s.charAt(high))
                high++;
            
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                low--; high++;
            }
            
            int width = high - low - 1;
            if (ansLen < width) {
                ansLen = width;
                start = low + 1;
            }
        }
        
        return s.substring(start, start + ansLen);
    }
}

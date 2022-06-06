/** Reverse Multiplication
 * Multiply each number in 2nd number with first number and store the
 * result in digit at (i + j) relative position of digits in respective numbers
 * Store the carry in the next position. Pop extra zeros and return reversed string
 * TC: O(M * N)
 * SC: O(M + N)
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int ansLen = num1.length() + num2.length(); // max len of multiplication
        
        // reverse nums as multiplication begins from end
        StringBuilder fn = new StringBuilder(num1);
        StringBuilder sn = new StringBuilder(num2);
        fn.reverse();
        sn.reverse();
        
        // Initialize ans with zeros
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ansLen; i++) {
            ans.append(0);
        }
        
        for (int i = 0; i < sn.length(); i++) {
            int d2 = sn.charAt(i) - '0';    // digit from second number
            
            // Multiply with every digit of first number and store in ans
            for (int j = 0; j < fn.length(); j++) {
                int d1 = fn.charAt(j) - '0';
                int currPos = i + j;    // place wrt position of d1 & d2
                
                int carry = ans.charAt(currPos) - '0';
                int mult = d1 * d2 + carry;
                
                // curr place as ones place of mult
                ans.setCharAt(currPos, (char)(mult % 10 + '0'));
                // next place as carry
                int val = (ans.charAt(currPos + 1) - '0') + mult / 10;
                ans.setCharAt(currPos + 1, (char)(val + '0'));
            }
        }
        
        // remove extra zeros at the end
        if (ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        
        ans.reverse();
        return ans.toString();
    }
}
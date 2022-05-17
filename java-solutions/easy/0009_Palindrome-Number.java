/**
 * Negative numbers will never be palindrome
 * First Loop: find number of digits in given int
 * Second 1/2 Loop: Split in two where first half is preserved and second half is reversed in seperate int
 * Trick for odd number of digits: ignore the mid digit
 * TC: O(n) -> where 'n' is the number of digits in int (max int 2147483647, thus max 11 digits)
 * SC: O(1) -> No extra auxilary space (just another int to store second half)
 */
 class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        // calc the number of digits
        int a = x, numDigits = 0;
        while (a > 0) {
            numDigits++;
            a /= 10;
        }
        
        // split in first half (= x) (in order) and second half (opposite order)
        int secondHalf = 0;
        for (int i = 0; i < numDigits/2; i++) {
            secondHalf = secondHalf*10 + x%10;
            x /= 10;
        }
        
        // No need to check middle digit for odd numDigits
        if (numDigits % 2 == 1) x /= 10;
        
        return (x == secondHalf) ? true : false;
    }
}
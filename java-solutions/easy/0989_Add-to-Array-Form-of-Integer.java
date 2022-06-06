/**
 * Textbook addition from last place.
 * Add element from array to curr and pick last digit of current for ans
 * Repeat till arr exhausts or curr still has value
 * TC: O(max(num.length, logK))
 * SC: O(max(num.length, logK))
 */
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int len = num.length;
        int curr = k;
        List<Integer> ans = new ArrayList<>();
        
        int i = len;
        while (--i >= 0 || curr > 0) {
            if (i >= 0) 
                curr += num[i];
            ans.add(curr % 10);
            curr /= 10;
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
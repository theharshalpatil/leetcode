// Binary search for square root
class Solution {
    public int mySqrt(int x) {
        long l = 1, r = x, mid = 0;
        
        while (r >= l) {
            mid = l + (r-l)/2;
            if (mid*mid == x) return (int) mid;
            else if (mid*mid > x) r = mid - 1;
            else if (mid*mid < x) l = mid + 1;
        }
        
        return (l>r) ? (int) r : (int) mid;
    }
}
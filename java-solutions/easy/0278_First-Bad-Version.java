/** Binary-Search */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans = n;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        return ans;
    }
}
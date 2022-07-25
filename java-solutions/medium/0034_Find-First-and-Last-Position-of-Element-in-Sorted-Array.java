/** Binary Search + Pivot expansion
 * Find one idx of the number using binary search.
 * Look in both directs untill a different number is encountered or OOB
 * TC: O(N)     -> Why? if the nums[] is filled with target. then we're effectively iterating over whole [] to find first/second
 * SC: O(logN)  -> Recursion tree
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pivot = binarySearch(nums, 0, nums.length - 1, target);
        if (pivot == -1) return new int[]{-1, -1};
        
        int first = pivot, second = pivot;
        while (first > 0 && nums[pivot] == nums[first-1]) first--;
        while (second < nums.length - 1 && nums[pivot] == nums[second + 1]) second++;
        
        return new int[]{first, second};
    }
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        
        int mid = start + (end - start)/2;
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return binarySearch(nums, start, mid - 1, target);
        return binarySearch(nums, mid + 1, end, target);
    }
}

/** Two Binary-Searches
 * TC: O(logN)  -> do Bin-Search just twice
 * SC: O(1)     -> No recursion stack since iterative approach
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1, first = -1;
        int mid = 0;
        
        while (start <= end) {
            mid = start + (end - start)/2;
            if (target == nums[mid])
                first = mid;
            if (target <= nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (first == -1) return new int[]{-1, -1};
        
        int second = -1;
        start = 0; end = nums.length - 1;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (target == nums[mid])
                second = mid;
            if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return new int[]{first, second};
    }
}
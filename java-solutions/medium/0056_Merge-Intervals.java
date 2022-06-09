/**
 * Sort the int[][] on basis of first element on an interval.
 * If intervals are to overlap, now they'll always be adjecent
 * TC: O(N * logN)
 * SC: O(1)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // Sort input on the basis of first element
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> ans = new ArrayList<>();
        int[] currInterval = intervals[0];
        ans.add(currInterval);
        
        for (int[] interval: intervals) {
            if (currInterval[1] >= interval[0]) {
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            } else {
                currInterval = interval;
                ans.add(currInterval);
            }
        }
        
        
        return ans.toArray(new int[ans.size()][]);
    }
}
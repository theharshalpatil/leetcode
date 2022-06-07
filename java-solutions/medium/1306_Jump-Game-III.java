/**
 * We do a recursive BFS and store if we've already checked this location
 * If we reach '0' return true, if we go OOB return false, if we've seen this loc return false
 * TC: O(N)     -> Each index shall be checked only once
 * SC: O(N)     -> To store if we've visited an index
 */
class Solution {
    boolean[] seen;
    public boolean canReach(int[] arr, int start) {
        seen = new boolean[arr.length];
        return getReach(arr, start);
    }
    
    private boolean getReach(int[] arr, int start) {
        if (start >= arr.length || start < 0) return false;
        if (seen[start]) return false;
        else seen[start] = true;
        if (arr[start] == 0) return true;
        
        return getReach(arr, start - arr[start]) || getReach(arr, start + arr[start]);
    }
}
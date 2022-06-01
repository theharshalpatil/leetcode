/**
 * Sort the arrays. Have two pointers for each and move untill one of the arrays exhaust.
 * Add number to result if both values match. Else increment pointer on lower valued array.
 * TC: O(N * logN)  -> N is len of bigger array (Sorting takes most time)
 * SC: O(1)         -> Not considering result array
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        return res.stream().mapToInt(k -> k).toArray();
    }
}
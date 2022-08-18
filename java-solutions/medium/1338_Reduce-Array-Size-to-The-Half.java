/**
 * Count the number of occurences of each int and start removing from most occouring
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i: arr)
            count.put(i, count.getOrDefault(i, 0) + 1);
        
        List<Integer> sorted = new ArrayList<>(count.values());
        Collections.sort(sorted, Collections.reverseOrder());
        
        int n = arr.length;
        int ans = 0;
        int cnt = 0;
        while (cnt < n/2) {
            cnt += sorted.get(ans);
            ans += 1;
        }
        
        return ans;
    }
}

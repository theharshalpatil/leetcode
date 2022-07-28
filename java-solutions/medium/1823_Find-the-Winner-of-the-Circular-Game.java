/** Simulation
 * TC: O(N*k)
 * SC: O(N)
 */
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.add(i);
        
        int curr = 0;
        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                curr = q.remove();
                q.add(curr);
            }
            q.remove();
        }
        
        return q.remove();
    }
}

/** Use ArrayList
 * Calculate the idx to remove, and remove it - note this will be the next starting idx
 * TC: O(N)
 * SC: O(N)
 */
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i < n+1; i++) lst.add(i);
        
        int curr = 0;
        while (lst.size() > 1) {
            curr = (curr + k - 1) % lst.size();
            lst.remove(curr);
        }
        
        return lst.get(0);
    }
}
/**
 * Record availability of each number and as you form groups monitor vacancy of new numbers
 * Every number can go with two choices:
 *      1. Be part of existing group (preferred greedy)
 *      2. Make a new group with N, N+1, N+2
 *      3. If 1/2 aren't possible, such a splitting isn't possible
 * TC: O(N) -> Two iterations over nums[]
 * SC: O(N) -> Two Maps
 */
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> availability = new HashMap<>();
        Map<Integer, Integer> vacancy = new HashMap<>();
        
        for (int n: nums) {
            availability.put(n, availability.getOrDefault(n, 0) + 1);
        }
        
        for (int n: nums) {
            if (availability.get(n) <= 0) continue;
            
            // 1. can 'n' be part of existing group?
            if (vacancy.getOrDefault(n, 0) > 0) {
                availability.put(n, availability.get(n) - 1); // no longer available
                vacancy.put(n, vacancy.get(n) - 1);           // remove vacancy as used
                vacancy.put(n + 1, vacancy.getOrDefault(n+1, 0) + 1); // vacancy for next int
            }
            
            // 2. can 'n', 'n+1', 'n+2' form a new group?
            else if (availability.getOrDefault(n, 0) > 0
                     && availability.getOrDefault(n+1, 0) > 0
                     && availability.getOrDefault(n+2, 0) > 0) {
                // make a new group
                availability.put(n, availability.get(n) - 1);
                availability.put(n+1, availability.get(n+1) - 1);
                availability.put(n+2, availability.get(n+2) - 1);
                
                // vacancy for next
                vacancy.put(n+3, vacancy.getOrDefault(n+3, 0) + 1);
            }
            
            // 3. if none of 1/2, then groups cant be formed
            else {
                return false;
            }
        }
        
        // if you reach here, all groups are formed
        return true;
    }
}

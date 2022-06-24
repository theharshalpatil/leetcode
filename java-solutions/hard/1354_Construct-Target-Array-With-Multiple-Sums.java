/**
 * We start opposite by looking at target and replacing the biggest element with prev state.
 * Repeat this till we reach [1]*n or return false
 * To avoid multiple loops when one of the numbers is too large, we make use of the '%' to skip overhead subtractions
 * To get the largest element and replacing with mod, use max-heap as it's the fastest for such cases
 * TC: O(N * logN)  -> due to Priority-Queue
 * SC: O(N)         -> to build max-heap
 */
class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int sum = 0;
        for (int n: target) {
            pQueue.add(n);
            sum += n;
        }
        
        int curr = 0, x = 0;
        while (pQueue.peek() != 1) {
            curr = pQueue.poll();
            if (sum - curr == 1) return true;
            
            x = curr % (sum - curr);
            sum = sum - curr + x;
            
            if (x == 0 || x == curr) return false;
            else pQueue.add(x);
        }
        
        return true;
    }
}
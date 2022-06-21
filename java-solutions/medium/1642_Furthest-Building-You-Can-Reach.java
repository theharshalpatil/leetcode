/**
 * Maintain a PQ to store the maximum bricks used for a jump.
 * If we've exhausted the bricks, replace the max brick jump with ladder.
 * If we now exhaust the ladders too, we can move no further and return curr idx
 * TC: O(nlogn) -> PQueue
 * SC: O(N)     -> PQueue
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i+1]) continue;
            bricks -= heights[i+1] - heights[i];
            pq.add(heights[i+1] - heights[i]);
            
            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0)
                    ladders--;
                else
                    return i;
            }
        }
        
        return heights.length - 1;
    }
}
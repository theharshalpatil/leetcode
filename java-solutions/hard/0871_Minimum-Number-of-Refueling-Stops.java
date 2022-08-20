/** Dynamic Programming
 * dp[i] stores the farthest we can go with 'i' refueling stops, we want least i for dp[i]>=target
 * TC: O(N^2)
 * SC: O(N)
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N+1];
        dp[0] = startFuel;
        
        for (int i = 0; i < N; i++) {
            for (int t = i; t >= 0; t--) {
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);
            }
        }
        
        for (int i = 0; i <= N; i++) {
            if (dp[i] >= target) return i;
        }
        
        return -1;
    }
}

/** Max-Heap
 * We keep track of the capacity of stations seen so far and try to take our driver as far as possible
 * if at a station the tank becomes < 0, we look at our heap to fill fuel from max capacity station
 * this will greedily minimize the number of stations we stop at
 * TC: O(N logN)
 * SC: O(N)
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int ans = 0, prev = 0;
        for (int[] station: stations) {
            int loc = station[0];
            int cap = station[1];
            startFuel -= loc - prev; // startingFuel at this station
            while (!pq.isEmpty() && startFuel < 0) {
                startFuel += pq.poll();
                ans++;
            }
            if (startFuel < 0) return -1;
            pq.offer(cap);
            prev = loc;
        }
        
        // what if target is further than last stop?
        startFuel -= target - prev;
        while (!pq.isEmpty() && startFuel < 0) {
            startFuel += pq.poll();
            ans++;
        }
        if (startFuel < 0) return -1;
        
        return ans;
    }
}

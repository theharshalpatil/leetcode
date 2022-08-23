/**
 * Create two adj-list (straight and reverse)
 * Judge shall have len==0 in straight while len==n-1 in reverse
 * TC: O(N)
 * SC: O(N)
 * NOTE: leetcode time 31ms
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> rgraph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
            rgraph.put(i, new ArrayList<>());
        }
        for (int[] t: trust) {
            graph.get(t[0]).add(t[1]);
            rgraph.get(t[1]).add(t[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() == 0 && rgraph.get(i).size() == n-1)
                return i;
        }
        
        return -1;
    }
}

/** Optimized
 * Count indegree (as number of people who trust i) and outdegree (as number of people i trusts)
 * if outdegree[i]==0 && indegree[i]==n-1, you've your judge
 * TC: O(N)
 * SC: O(N)
 * NOTE: 15x faster than prev on leetcode (2ms)
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        for (int[] t: trust) {
            indegree[t[1]]++;
            outdegree[t[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n-1)
                return i;
        }
        return -1;
    }
}

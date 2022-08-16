/**
 * Classic BFS (Can also be a DFS w/ stack)
 * TC: O(N + E)     -> N = number of rooms, E = number of Keys
 * SC: O(N)         -> Store visited & queue
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            for (int neigh: rooms.get(curr)) {
                if (!visited[neigh])
                    q.add(neigh);
            }
        }
        
        for (boolean v: visited)
            if (!v) return false;
        
        return true;
    }
}

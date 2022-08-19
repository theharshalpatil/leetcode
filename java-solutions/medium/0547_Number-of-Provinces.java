/** DFS
 * As you see a new node, count it as a province ans mark all connects as seen using dfs
 * TC: O(N^2)   -> as for every i in [0, N), we check if j in [0, N) is connected
 * SC: O(N)     -> To maintain visited array
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++)
            count += dfs(i, isConnected, visited);
        
        return count;
    }
    
    private int dfs(int idx, int[][] mat, boolean[] vis) {
        if (vis[idx]) return 0;
        vis[idx] = true;
        // mark province visited with dfs
        for (int j = 0; j < mat.length; j++) {
            if (idx != j && mat[idx][j] == 1)
                dfs(j, mat, vis);
        }
        return 1;   // count this province
    }
}

/**
 * DSU - using Union Find we can get number of disjoint sets
 * TC: O(N) for Union + O(N) for unique roots
 * SC: O(N)
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (isConnected[a][b] == 1) uf.union(a, b);
            }
        }
        
        return uf.uniqueRoots();
    }
    
    public class UnionFind {
        int[] root;
        int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) root[rooty] = rootx;
                else if (rank[rootx] < rank[rooty]) root[rootx] = rooty;
                else {
                    root[rootx] = rooty;
                    rank[rooty] += 1;
                }
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int uniqueRoots() {
            int ans = 0;
            for (int i = 0; i < root.length; i++)
                if (root[i] == i) ans++;
            return ans;
        }
    }
}

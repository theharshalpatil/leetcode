/** Breadth First Search
 * Make a class to denote where the node is in the matrix. To maintain order let that class be comparable
 * as you BFS, add nodes to PQ and the dequeue order should be automatically taken care of
 * TC: O(N)     -> each node is visited twice
 * SC: O(N)     -> PQ will hold all the node 'Pair's
 */
class Solution {
    static int minCol;
    static int maxCol;
    static List<List<Integer>> ans;
    static PriorityQueue<Pair> pq;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans = new ArrayList<List<Integer>>();
        bfs(root);
        
        int numOfCols = maxCol - minCol;
        for (int i = 0; i <= numOfCols; i++)
            ans.add(new ArrayList<Integer>());
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            ans.get(-minCol+curr.col).add(curr.node.val);
        }
        
        return ans;
    }
    
    private void bfs(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        pq = new PriorityQueue<Pair>();
        int row = 0, col = 0;
        q.add(new Pair(0, 0, root));
        
        minCol = 0;
        maxCol = 0;
        row = 1;
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            pq.add(curr);
            
            if (curr.node.left != null) {
                q.add(new Pair(curr.row + 1, curr.col - 1, curr.node.left));
                minCol = Math.min(minCol, curr.col - 1);
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.row + 1, curr.col + 1, curr.node.right));
                maxCol = Math.max(maxCol, curr.col + 1);
            }
        }
    }
    
    class Pair implements Comparable<Pair>{
        int col;
        int row;
        TreeNode node;
        public Pair(int r,int c, TreeNode n){
            row=r;
            col=c;
            node=n;
        }
        public int compareTo(Pair p){
            if(col!=p.col) return col-p.col;
            if(row!=p.row) return row-p.row;
            return node.val-p.node.val;
        }
    }
}


/**
 * Depth First Search
 * TC: O(N)
 * SC: O(N)
 * Not So efficient
 */
class Solution {
    Map<String, List<Integer>> verticalMap = new HashMap<>();
    int min, max;
    int height;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        dfs(root, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j <= height; j++) {
                String key = i + "," + j;
                if (verticalMap.containsKey(key)) {
                    List<Integer> curr = verticalMap.get(key);
                    Collections.sort(curr);
                    col.addAll(curr);
                }
            }
            ans.add(col);
        }
        
        return ans;
    }
    
    public void dfs(TreeNode root, int col, int h) {
        if (root == null) {
            height = Math.max(height, h-1);
            return;
        }
        String key = col + "," + h;
        if (!verticalMap.containsKey(key))
            verticalMap.put(key, new ArrayList<>());
        min = Math.min(min, col);
        max = Math.max(max, col);
        verticalMap.get(key).add(root.val);
        dfs(root.left, col - 1, h + 1);
        dfs(root.right, col + 1, h + 1);
    }
}

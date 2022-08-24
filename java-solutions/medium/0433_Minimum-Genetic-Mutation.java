/** Plain old BFS
 * TC: O(N*len(start)) -> Queue will end up running only till bank size * finding mutation for each state
 * SC: O(N) -> Bank size
 */
class Solution {
    public int minMutation(String start, String end, String[] B) {
        if (start.equals(end)) return 0;
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        
        Set<String> bank = new HashSet<>();
        for (String b: B) bank.add(b);
        
        int mutations = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(end)) return mutations;
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < sb.length(); i++) {
                    for (char c: choices) {
                        sb.setCharAt(i, c);
                        String tmp = sb.toString();
                        if (bank.contains(tmp)) {
                            q.add(tmp);
                            bank.remove(tmp);
                        }
                        sb.setCharAt(i, curr.charAt(i));
                    }
                }
            }
            mutations++;
        }
        
        return -1;
    }
}

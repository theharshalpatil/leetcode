/**
 * Each diagonal has a unique row-col value. Put these number in a list, sort, and put back in place
 * TC: O(R*C)   -> Sorting will take max NlogN where N is number of elements in diag
 * SC: O(R*C)   -> All the elments are put in a hashmap as diagonal lists
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Map<Integer, List<Integer>> diags = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!diags.containsKey(i-j))
                    diags.put(i-j, new ArrayList<>());
                diags.get(i-j).add(mat[i][j]);
            }
        }
        
        for (int key: diags.keySet())
            Collections.sort(diags.get(key));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = diags.get(i-j).get(0);
                diags.get(i-j).remove(0);
            }
        }
        
        return mat;
    }
}

/**
 * We just need the previous row to compute current row!
 * TC: O(N^2)   -> Still have to go through all rows
 * SC: O(N)     -> Just store previous row
 */
class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = null, pre = null;
        
        for (int i = 0; i <= rowIndex; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(pre.get(j-1) + pre.get(j));
            }
            pre = row;
        }
        
        return row;        
    }
}
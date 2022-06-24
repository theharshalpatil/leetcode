/** Dynamic Programming
 *  TC: O(N^2)
 *  SC: O(N)
 */
class Solution {
    int ans;
    public int numTrees(int n) {
        int[] numOfTrees = new int[n + 1];
        // 0, 1 nodes will have only 1 tree possible
        Arrays.fill(numOfTrees, 1);
        
        // filling rest as
        // numOfTrees[4] = numOfTrees[0] * numOfTrees[3] +
        //                  numOfTrees[1] * numOfTrees[2] +
        //                  numOfTrees[2] * numOfTrees[1] +
        //                  numOfTrees[3] * numOfTrees[0]
        for (int i = 2; i < n + 1; i++) {
            int total = 0;
            for (int j = 0; j < i; j++) {
                total += numOfTrees[j] * numOfTrees[i - j - 1];
            }
            numOfTrees[i] = total;
        }
        
        return numOfTrees[n];
    }
}
/** Brute-Force
 * TC: O(N^3 * M^3)
 * SC: O(1)
 * Ofcourse, TLE
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int total = 0;
        int ans = 0;
        
        for (int y1 = 0; y1 < m; y1++) {
            for (int x1 = 0; x1 < n; x1++) {
                for (int y2 = y1; y2 < m; y2++) {
                    for (int x2 = x1; x2 < n; x2++) {
                        total = 0;
                        for (int r = y1; r <= y2; r++) {
                            for (int c = x1; c <= x2; c++) {
                                total += matrix[r][c];
                            }
                        }
                        if (total == target) ans++;
                    }
                }
            }
        }
        
        return ans;
    }
}

/**
 * We can make the 'total' calculation part O(1) by implementing 2D prefix sum
 * TC: O(N^2 * M^2) -> Calculation of prefixSum O(MN) + finding number of matrices
 * SC: O(N * M)     -> To store prefixSum matrix
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int total = 0;
        int ans = 0;
        
        // Calculate prefix sum
        int[][] prefixSum = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r != 0 && c != 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r-1][c] + prefixSum[r][c-1] - prefixSum[r-1][c-1];
                else if (r == 0 && c == 0)
                    prefixSum[r][c] = matrix[r][c];
                else if (r == 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r][c-1];
                else if (c == 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r-1][c];
            }
        }
        
        for (int y1 = 0; y1 < m; y1++) {
            for (int x1 = 0; x1 < n; x1++) {
                for (int y2 = y1; y2 < m; y2++) {
                    for (int x2 = x1; x2 < n; x2++) {
                        total = prefixSum[y2][x2];
                        if (x1 > 0) total -= prefixSum[y2][x1-1];
                        if (y1 > 0) total -= prefixSum[y1-1][x2];
                        if (x1 > 0 && y1 > 0) total += prefixSum[y1-1][x1-1];
                        if (total == target) ans++;
                    }
                }
            }
        }
        
        return ans;
    }
}

/**
 * We can boil down getting the number of matrices equaling to target by using subarraysum
 * This is similar to the 1D problem
 * TC: O(M^2 * N)   -> O(MN) for prefixSum calcultaion. O(M^2 * N) for finding ans
 * SC: O(MN)        -> Prefix Sum O(MN). SubarrayMap O(N)
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int total = 0;
        int ans = 0;
        
        // Calculate prefix sum
        int[][] prefixSum = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r != 0 && c != 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r-1][c] + prefixSum[r][c-1] - prefixSum[r-1][c-1];
                else if (r == 0 && c == 0)
                    prefixSum[r][c] = matrix[r][c];
                else if (r == 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r][c-1];
                else if (c == 0)
                    prefixSum[r][c] = matrix[r][c] + prefixSum[r-1][c];
            }
        }
        
        int matrixSum = 0;
        for (int y1 = 0; y1 < m; y1++) {
            for (int y2 = y1; y2 < m; y2++) {
                Map<Integer, Integer> subarraySum = new HashMap<>();
                subarraySum.put(0, 1);
                
                for (int x = 0; x < n; x++) {
                    matrixSum = prefixSum[y2][x];
                    // remove matrix sum above y1
                    if (y1 > 0) matrixSum -= prefixSum[y1-1][x];
                    if (subarraySum.containsKey(matrixSum - target))
                        ans += subarraySum.get(matrixSum - target);
                    
                    subarraySum.put(matrixSum, subarraySum.getOrDefault(matrixSum, 0) + 1);
                }
            }
        }
        
        return ans;
    }
}
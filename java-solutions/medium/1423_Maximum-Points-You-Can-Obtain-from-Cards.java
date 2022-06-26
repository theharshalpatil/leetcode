/**
 * Recursive: Take two choices and run DFS on each of them
 * TC: O(2^k)
 * SC: O(1)
 * TLE on leetcode
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        return pickCardAndScore(cardPoints, 0, cardPoints.length - 1, k);
    }
    
    public int pickCardAndScore(int[] cardPoints, int i, int j, int k) {
        if (k == 0) return 0;
        
        if (i >= cardPoints.length)
            return cardPoints[j] + pickCardAndScore(cardPoints, i, j-1, k - 1);
        else if (j < 0)
            return cardPoints[i] + pickCardAndScore(cardPoints, i+1, j, k - 1);
        else
            return Math.max(cardPoints[i] + pickCardAndScore(cardPoints, i+1, j, k - 1),
                        cardPoints[j] + pickCardAndScore(cardPoints, i, j-1, k - 1));
    }
}

/**
 * To maximize the sum of choices, we need to exclude the sum of array of len (N - k)
 * such that it is minimum. Now the problem boils down to finding min sum of len(N - k)
 * TC: O(N)
 * SC: O(1)
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int n: cardPoints) total += n;
        if (k == cardPoints.length) return total;
        
        int N = cardPoints.length;
        int curr = 0;
        
        // Initialize window
        for (int i = 0; i < N - k; i++) curr += cardPoints[i];
        int min = curr;
        
        // check for all windows
        for (int i = N - k; i < N; i++) {
            curr += cardPoints[i] - cardPoints[i - N + k];
            min = Math.min(min, curr);
        }
        
        return total - min;
    }
}
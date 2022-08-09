class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        Arrays.sort(arr);
        // Since all vals of arr are unique
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < N; i++)
            idxMap.put(arr[i], i);
        
        // trees[i] = trees[a] * trees[b] for every arr[a]*arr[b]=arr[i]
        long[] trees = new long[N];
        Arrays.fill(trees, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) { // found left child
                    int right = arr[i] / arr[j];    // left * right = curr
                    if (idxMap.containsKey(right)) {
                        trees[i] = (trees[i] + trees[j]*trees[idxMap.get(right)]) % MOD;
                    }
                }
            }
        }
        
        long ans = 0;
        for (long n: trees) {
            ans += n;
            ans %= MOD;
        }
        return (int) ans;
    }
}

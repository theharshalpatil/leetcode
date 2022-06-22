/**
 * Sort the array, return (len - k)th element
 * TC: O(N logN)
 * SC: O(1)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

/**
 * Use a max priorityQ to put elements O(N)
 * Then remove 'k' elements O(K * logN)
 * TC: O(N + K*logN)
 * SC: O(N)
 */
 class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums)
            pq.add(n);
        while (k-- > 1)
            pq.poll();
        return pq.poll();
    }
}


/**
 * Quick-Search. Pivot an element and rearrange
 * Such that all to left are small than pivot and to right are greater
 * If (p == len-k) return the val -> we found it
 * else if (p > len-k) repeat for right partition
 * else repeat for left partition
 * TC: O(N) -> avg case as each time you partition you search for (N + N/2 + N/4 + ...) = O(2N)
 * TC: O(N^2) -> worst case as each time pivot can end up at the end of arr so (N + (N-1) + (N-2) ...) = O(N*(N-1)/2)
 * SC: O(1)
 */
 class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == k) return nums[k];
        else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
        return quickSelect(nums, left, pIndex-1, k);
    }

    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i=left; i<=right; i++) 
            if (nums[i] <= pivot) 
                swap(nums, i, pIndex++);

        return pIndex - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
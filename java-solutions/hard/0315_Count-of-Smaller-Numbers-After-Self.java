/** Sorting + Binary Search
 * The idea is to sort the numbers and do a binary serach to find the location of the number (n).
 * This location gives you the number of how many nums are lesser than 'n'. The trick is to start from behind
 * TC: O(N logN)    -> Sorting (NlogN), Iteration (N), binary search (logN)
 * SC: O(N)
 */
class Solution {
    List<Integer> arr;
    public List<Integer> countSmaller(int[] nums) {
        arr = new ArrayList<>();
        for (int n: nums) arr.add(n);
        Collections.sort(arr);
        int idx;
        List<Integer> ans = new ArrayList<>();
        
        for (int n: nums) {
            idx = binarySearch(n, 0, arr.size() - 1);
            ans.add(idx);
            arr.remove(idx);
        }
        
        return ans;
    }
    
    public int binarySearch(int n, int l, int r) {
        int mid = l + (r-l)/2;
        
        while (l <= r) {
            mid = l + (r - l)/2;
            int num = arr.get(mid);
            if (num == n) {
                while (mid > 0 && arr.get(mid-1) == num) mid -= 1;
                return mid;
            }
            else if (num > n) r = mid - 1;
            else if (num < n) l = mid + 1;
        }
        
        return mid;
    }
}

/**
 * The idea is to count the pairs that meet the criteria in the sorted left/right part of a subarray and merge that subarray after that.
 * TC: O(NlogN)
 * SC: O(N)
 * This is way faster than the previous approach (~ 5x faster)
 */
class Solution {
    class Pair {
        int val;
        int idx;
        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    private int[] res;
    private Pair[] pairs;
    
    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) pairs[i] = new Pair(nums[i], i);
        
        mergeSort(0, nums.length - 1);
        return IntStream.of(res).boxed().collect(Collectors.toList());
    }
    
    public void mergeSort(int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left)/2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        
        // count
        int count = 0;
        for (int ll = left, rr = mid+1; ll <= mid;) {
            if (rr <= right && pairs[ll].val > pairs[rr].val) {
                count++;
                rr++;
            } else {
                res[pairs[ll].idx] += count;
                ll++;
            }
        }
        
        // merge
        Pair[] tmp = new Pair[right-left+1];
        int l = left, r = mid+1, k = 0;
        while(l <= mid || r <= right) {
            if (l <= mid && (r > right || pairs[l].val <= pairs[r].val)) {
                tmp[k++] = pairs[l++];
            } else {
                tmp[k++] = pairs[r++];
            }
        }
        
        for (int i = 0; i < tmp.length; i++) {
            pairs[left+i] = tmp[i];
        }
    }
}
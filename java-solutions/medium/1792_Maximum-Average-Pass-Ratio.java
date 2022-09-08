/**
 * Keep a max heap of the current class sizes and order them by the change in pass ratio.
 * For each extra student, take the top of the heap, update the class size, and put it back in the heap.
 * TC: O(NlogN + ES*logN + N)
 * SC: O(N)
 */
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int N = classes.length;
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<double[]>((a, b) -> Double.compare(b[2], a[2]));
        for (int i = 0; i < N; i++) {
            double changeInPassRatio = (double)(classes[i][0] + 1)/(double)(classes[i][1] + 1);
            changeInPassRatio -= (double)classes[i][0]/(double)classes[i][1];
            maxHeap.add(new double[]{classes[i][0], classes[i][1], changeInPassRatio});
        }
        
        while (extraStudents-- > 0) {
            double[] curr = maxHeap.poll();
            curr[0]++;
            curr[1]++;
            curr[2] = ((curr[0] + 1)/(curr[1] + 1)) - (curr[0]/curr[1]);
            maxHeap.add(curr);
        }
        
        double ans = 0;
        while (maxHeap.size() > 0) {
            double[] curr = maxHeap.poll();
            ans += curr[0] / curr[1];
        }
        
        return ans/N;
    }
}

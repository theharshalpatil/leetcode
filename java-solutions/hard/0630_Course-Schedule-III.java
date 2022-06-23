/**
 * Sort on the basis of end date of course.
 * Choose each couse if running time is less than end date
 * If running time exceeds, find a course that took the maximum duration and
 *      remove it if curr course can be taken up.
 * TC: O(NlogN + N^2)
 * SC: O(1)
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0])
                    time += courses[i][0] - courses[max_i][0];
                courses[max_i][0] = -1;
            }
        }
        
        return count;
    }
}

/**
 * Optimization: whenever we update the countcount to indicate that one more course has been taken,
 * we also update the courses[count]courses[count] entry to reflect the current course that has just been taken.
 * TC: O(n∗count). We iterate over a total of nn elements of the coursescourses array.
 *          For every element, we can traverse backwards upto atmost countcount(final value) number of elements.
 * SC: O(1)
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                courses[count++] = courses[i];
            } else {
                int max_i = i;
                for (int j = 0; j < count; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                    courses[max_i] = courses[i];
                }
            }
        }
        
        return count;
    }
}
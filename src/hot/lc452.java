package hot;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgl
 * @create 2021-06-15 16:33
 */
public class lc452 {
    public static void main(String[] args) {
        lc452 lc452 = new lc452();
        int[][] points = new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}};
        System.out.println(lc452.findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] nums1, int[] nums2) {
                return nums1[0] - nums2[0];
            }
        });
        int count = 1;
        int[] note = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > note[1]) {
                count++;
                note = points[i];
            } else {
                note[0] = points[i][0];
            }
        }
        count++;
        count--;
        return count;
    }
}

package experience;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgl
 * @create 2021-09-03 21:03
 */
public class myTest {
    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        myTest myTest = new myTest();
        System.out.println(myTest.maxSubArray(nums));

//        Arrays.<Integer>sort((Integer[])nums, (x, y) -> x - y);
        int[][] nums2 = new int[][]{{1,3},{1,2},{4,5},{3,7}};
        System.out.println(myTest.maxSubArray(nums));


        int[][] nums1 = new int[][]{{1,3},{1,2},{4,5},{3,7}};
        Arrays.sort(nums1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int lastMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            lastMax = Math.max(lastMax + nums[i], nums[i]);
            if (max < lastMax) {
                max = lastMax;
            }
        }
        return max;
    }
}

package hot;

/**
 * @author wgl
 * @create 2021-06-09 10:48
 */
public class hot4 {
    public static void main(String[] args) {
        hot4 hot4 = new hot4();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(hot4.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            int k = (nums1.length + nums2.length)/2 + 1;
            return bs(nums1, nums2, k, 0, 0);
        } else {
            int k1 = (nums1.length + nums2.length)/2;
            int k2 = (nums1.length + nums2.length)/2 + 1;
            return (double)(bs(nums1, nums2, k1, 0, 0) + bs(nums1, nums2, k2, 0, 0))/2.0;
        }
    }
    public int bs(int[] nums1, int[] nums2, int k, int start1, int start2) {
        //如果其中一个数组减完了，则返回另一个数组对应位置上的值
        if (start1 == nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 == nums2.length) {
            return nums1[start1 + k - 1];
        }
        //如果只剩一个K，就返回较小的一个数
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //一定要判断，取目标值和最大下标的最小值，防止越界
        int l1 = Math.min(start1 + k/2 - 1, nums1.length - 1);
        int l2 = Math.min(start2 + k/2 - 1, nums2.length - 1);
        if (nums1[l1] < nums2[l2]) {
            k  = k - (l1 - start1 + 1);
            l1++;
            return bs(nums1, nums2, k, l1, start2);
        } else {
            k  = k - (l2 - start2 + 1);
            l2++;
            return bs(nums1, nums2, k, start1, l2);
        }
    }
}

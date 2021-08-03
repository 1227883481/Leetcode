package labuladong;

/**
 * @author wgl
 * @create 2021-08-03 23:56
 */
public class find_middle_num {
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
        if (start1 == nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 == nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
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


        // if (l1 >= nums1.length) {
        //     // l1 = nums1.length;
        //     k = k - (nums1.length - start1);
        //     return bs(nums1, nums2, k, nums1.length, start2);
        // }
        // if (l2 >= nums2.length) {
        //     // l2 = nums2.length;
        //     k = k - (nums2.length - start2);
        //     return bs(nums1, nums2, k, start1, nums2.length);
        // }
        // if (l1 < nums1.length && l2 < nums2.length) {
        //     if (l2 > l1) {
        //         start1 = l1;
        //     } else {
        //         start2 = l2;
        //     }
        //     k = k - k/2;
        // }
        // return bs(nums1, nums2, k, start1, start2);
    }
}


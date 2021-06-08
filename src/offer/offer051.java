package offer;

/**
 * @author wgl
 * @create 2021-06-07 16:17
 */
public class offer051 {
    int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,5,4};
        offer051 offer051 = new offer051();
        offer051.reversePairs(nums);
        System.out.println(offer051.count);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }
    public void mergeSort(int[] nums) {
        int start = 0;
        int len = nums.length;
        for (int i = 1; i < len; i = i * 2) {
            for (start = 0; start + i < len; start = start + 2*i) {
                merge(nums, start, Math.min(start + 2*i - 1, len - 1) );
            }
        }
    }
    public void merge(int[] nums, int start, int end) {
        int center = (start + end) / 2;
        int front = center - start + 1; //记录第一块的个数，算count用到
        int[] temp = new int[end - start + 1];
        int l = start, r = center + 1, index = 0;
        while (l <= start && r <= end) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l++];
            } else {
                count = count + (r - start - index);
                temp[index++] = nums[r++];
            }
        }
        while (l <= start) {
            temp[index++] = nums[l++];
        }
        while (r <= end) {
            temp[index++] = nums[r++];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = temp[index];
            index++;
        }
    }
}



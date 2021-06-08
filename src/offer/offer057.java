package offer;

import java.util.Arrays;

/**
 * @author wgl
 * @create 2021-05-12 19:50
 */
public class offer057 {
    public static void main(String[] args) {
        offer057 offer057 = new offer057();
        int[] nums = new int[]{2,7,11,15};
        int[] res = offer057.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
    public int[] twoSum(int[] nums, int target) {
        int slow = 0;
        int fast = nums.length - 1;
        int sum = nums[slow] + nums[fast];
        int[] res = new int[2];
        while (slow < fast) {
            if (sum > target) {
                fast--;
            } else if (sum < target) {
                slow++;
            } else {
                res[0] = nums[slow];
                res[1] = nums[fast];
                break;
            }
            sum = nums[slow] + nums[fast];
        }
        return res;
    }
}

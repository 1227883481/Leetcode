package offer;

import java.util.Arrays;

/**
 * @author wgl
 * @create 2021-06-05 16:56
 */
public class offer061 {
    public static void main(String[] args) {
        offer061 offer061 = new offer061();
        offer061.isStraight(new int[]{0,0,1,2,5});
    }
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0 = 0;
        // int gap = 0;
        int i = 0;
        while (nums[i++] == 0 && nums[i] != nums[i -1]) {
            count0++;
        }
        if (nums[nums.length - 1] - nums[count0] >= 5) {
            return false;
        } else {
            return true;
        }
    }

}

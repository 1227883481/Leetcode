package hot;

import java.util.*;

/**
 * @author wgl
 * @create 2021-06-12 16:12
 */
public class hot15 {
    public static void main(String[] args) {
        hot15 hot15 = new hot15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        hot15.threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
                while (k - 1 >= j && nums[k] == nums[k - 1]) {
                    k--;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> listTemp = new ArrayList<>();
                    listTemp.add(nums[i]);
                    listTemp.add(nums[j]);
                    listTemp.add(nums[k]);
                    list.add(listTemp);
                }
                if (sum > 0){
                    k--;
                    continue;
                }
                if (sum < 0) {
                    j++;
                    continue;
                }
            }
        }
        return list;
    }
}

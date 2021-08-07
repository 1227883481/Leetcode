package git;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgl
 * @create 2021-08-07 16:31
 */
public class SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> listTemp = new ArrayList<>();
                    listTemp.add(nums[i]);
                    listTemp.add(nums[j]);
                    listTemp.add(nums[k]);
                    list.add(listTemp);
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k - 1 >= j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                if (sum > 0){
                    while (k - 1 >= j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                    continue;
                }
                if (sum < 0) {
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    continue;
                }

            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return list;
    }
}

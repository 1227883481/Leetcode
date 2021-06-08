package offer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-05-16 23:14
 */
public class offer039 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < len; i++) {
            count = map.getOrDefault(nums[i], 0);
            if (count > len/2) {
                return nums[i];
            }
            map.put(nums[i], count+1);
        }
        return 1;
    }
    @Test
    public void test() {
        System.out.println(9/2);
    }
}

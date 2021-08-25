package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wgl
 * @create 2021-08-25 22:34
 */
public class topKNums {
    public int[] topK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((i, j) -> (j.getValue() - i.getValue()));

        for(Map.Entry entry : map.entrySet()) {
            queue.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = (int) queue.poll().getKey();
        }
        return res;
    }
}

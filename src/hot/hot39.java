package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgl
 * @create 2021-06-14 19:39
 */
public class hot39 {
    public static void main(String[] args) {
        hot39 hot39 = new hot39();
        hot39.combinationSum(new int[]{2,3,6,7}, 7);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        help(candidates, target, 0, list1, list2, 0);
        return list2;
    }
    public void help (int[] candidates, int target, int start, List<Integer> list1, List<List<Integer>> list2, int sum) {
        for (int i = start; i < candidates.length; i++) {
            int sum_cur = sum + candidates[i];
            list1.add(candidates[i]);
            if (sum > target) {
                list1.remove(list1.size() - 1);
                return;
            } else if (sum == target) {
                list2.add(new ArrayList<Integer>(list1));
                list1.remove(list1.size() - 1);
                return;
            } else {
                // list1.add(candidates[i]);
                help(candidates, target, i, list1, list2, sum_cur);
                list1.remove(list1.size() - 1);
            }
        }
    }
}

package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wgl
 * @create 2021-06-02 10:57
 */
public class offer049 {
    public static void main(String[] args) {
        offer049 offer049 = new offer049();
        offer049.nthUglyNumber(10);
        int[][] ints = new int[3][];
    }
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pri = new PriorityQueue<>();
        pri.add(1L);
        Set<Integer> set = new HashSet<>();
        int[] note = new int[]{2, 3, 5};

        int ugly = 1;
        for (int i = 0; i < n; i++) {
            long cur = pri.poll();
            ugly = (int)cur;
            if (set.add(ugly)) {
                for (int j : note) {
                    pri.add(j * cur);
                }
            }
        }
        return ugly;
    }
}

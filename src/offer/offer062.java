package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-06-06 0:45
 */
public class offer062 {

    public static void main(String[] args) {
        offer062 offer062 = new offer062();
        offer062.lastRemaining(5,3);
    }
    public int lastRemaining(int n, int m) {

        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int start = 0;
        while (list.size() > 1) {
            int temp = m % list.size();
            list.remove((temp - 1 + start) % list.size());
            start = (temp - 1 + start) % (list.size() + 1) % list.size();
        }
        return list.get(0);
    }
}

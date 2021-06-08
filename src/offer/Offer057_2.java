package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-06-05 10:27
 */
public class Offer057_2 {
    public static void main(String[] args) {
        Offer057_2 offer057_2 = new Offer057_2();
        offer057_2.findContinuousSequence(9);
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for (int i = target/2; i >= 2; i--) {
            if ((i % 2 == 1) && (target % i == 0)) {

                int div = target / i;
                int start = div - i/2;
                if (start <= 0) continue;
                int[] res = new int[i];
                for (int index = 0; index < i; index++) {
                    res[index] = start++;
                }
                list.add(res);

            } else if ((i % 2 == 0) && (target % i == i/2)){

                int div = target / i;
                int start = div - (i/2) + 1;
                if (start <= 0) continue;
                int[] res = new int[i];
                for (int index = 0; index < i; index++) {
                    res[index] = start++;
                }

            }
        }
        // int[][] result = new int[][];
        // for (int i = 0; i < list.size(); i++) {
        //     re[i] = list.get(i);
        // }

        return list.toArray(new int[list.size()][]) ;
    }
}

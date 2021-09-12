package experience;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgl
 * @create 2021-09-04 0:12
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.compare(3, 5));
        Integer[] intNum = new Integer[]{300,200,3,56,4};
        Arrays.sort(intNum, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {

                long sum1 = Long.parseLong(Integer.toString(num1) + Integer.toString(num2));
                long sum2 = Long.parseLong(Integer.toString(num2) + Integer.toString(num1));
                if (sum1 > sum2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(intNum));
    }
    public int compare(Integer num1, Integer num2) {

        long sum1 = Long.parseLong(Integer.toString(num1) + Integer.toString(num2));
        long sum2 = Long.parseLong(Integer.toString(num2) + Integer.toString(num1));
        if (sum1 > sum2) {
            return 1;
        } else {
            return -1;
        }
    }
}

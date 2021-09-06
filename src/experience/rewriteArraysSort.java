package experience;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wgl
 * @create 2021-09-03 22:39
 */
public class rewriteArraysSort {
    public static void main(String[] args) {
        Integer[] arr= {1,2,3,4,5,6};
        String[] nums = new String[]{"22", "22"};
        Comparator cmp = new MyComparator();
        Arrays.sort(nums, (x, y) -> (x + y).compareTo(y + x)); //(Integer)y - (Integer)x
    }

}
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        /*
         * 如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值， 这样颠倒一下，就可以实现降序排序了,反之即可自定义升序排序了
         */
        return o2 - o1;
    }
}


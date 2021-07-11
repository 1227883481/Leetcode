package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-07-11 15:40
 * hot100:最高温度在后面几天出现
 */
public class hot739 {
    public static void main(String[] args) {
        hot739 hot739 = new hot739();
        int[] input = new int[]{33,34,35,31,37};
        hot739.dailyTemperatures(input);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        List<List<Integer>> listTem = new ArrayList<>();
        for (int i = 30; i <= 100; i++) {
            listTem.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < temperatures.length; i++) {
            //temperindex是对应的几度
            int temperindex = temperatures[i] - 30;
            for (int j = 0; j < temperindex; j++) {
                List<Integer> temp = listTem.get(j);
                while(temp.size() > 0) {
                    //index是对应的温度处的第几天
                    int index = temp.get(temp.size() - 1);
                    res[index] = i - index;
                    temp.remove(temp.size() - 1);
                }
            }
            listTem.get(temperindex).add(i);
        }
        return res;
    }
}

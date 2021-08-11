package git;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-08-11 19:19
 */
public class lc13 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                sum = sum + map.get(s.substring(i));
                break;
            }
            int num1 = map.get(s.substring(i,i+1));
            int num2 = map.get(s.substring(i+1, i+2));
            if (num1 < num2) {
                sum = sum + num2 - num1;
                i++;
            } else {
                sum = sum + num1;
            }
        }
        return sum;
    }
}

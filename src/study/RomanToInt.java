package study;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-04-25 20:41
 */
public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        romanToInt.romanToInt("III");

    }

    public int romanToInt(String s) {
        s.substring(1,2);
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
                sum = sum + map.get(s.substring(i,i+1));
                break;
            }
            String s1 = s.substring(i,i+1);
            String s2 = s.substring(i+1,i+2);

            int num1 = map.get(s.substring(i,i+1));
            int num2 = map.get(s.substring(i + 1,i+2));
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

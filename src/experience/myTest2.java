package experience;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-09-04 10:47
 */
public class myTest2 {
    public static void main(String[] args) {
        myTest2 myTest2 = new myTest2();
        System.out.println(myTest2.lengthOfLongestSubstring("abcababb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 1;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {

            while(left < right && map.getOrDefault(s.charAt(right), 0) > 0) {
//                int countA = map.get(s.charAt(left)) - 1;
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                char c = s.charAt(right);
//                System.out.println(s.charAt(right));
                int temp = map.getOrDefault(c, 0);
                System.out.println(temp);
            }
            map.put(s.charAt(right), 1);
            if (map.size() > res) {
                res = map.size();
            }
            right++;
        }
        return res;

    }
}

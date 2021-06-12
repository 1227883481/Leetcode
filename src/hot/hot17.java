package hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-06-12 14:05
 */
public class hot17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }
        int len = digits.length();
        char[] arr = digits.toCharArray();
        List<String> list = new ArrayList<>();

        //创建Map
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder pre = new StringBuilder();
        help(pre, 0, arr, list, map);
        return list;
    }

    public void help(StringBuilder pre , int index, char[] arr, List list, Map<Character, String> map) {
        if (index >= arr.length) {
            list.add(pre);
            return;
        }
        char c = arr[index];
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            pre.append(str.substring(i, i+1));
            help (pre, index + 1, arr, list, map);
            pre.deleteCharAt(pre.length() - 1);   //删除最后一个字符
        }

    }
}

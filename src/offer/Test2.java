package offer;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author wgl
 * @create 2021-06-01 14:20
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(null);
//        deque.push(null);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);
        Stack<Integer> stack = new Stack<>();
        stack.add(null);

    }
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        if (s.length() == 1) return new String[]{s};
        Map<String, Integer> map = new HashMap<>();
        help(s, "", list, map);


        for (String key : map.keySet()) {
            temp.add(key);
        }
        String[] str = new String[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            str[i] = temp.get(i);
        }
        return str;
    }
    public void help(String s, String s_pre, List list, Map<String, Integer> map) {
        int len = s.length();
        if (len == 1) {
            String ss = s_pre + s;
            list.add(ss);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
            HashMap map1 = new HashMap<>();
            map.getOrDefault(ss, 1);
            map.put(ss,  + 1);
            return;
        }
        for (int i = 0; i < len; i++) {
            String s_i = s.substring(i,i+1);
            String s_rem = s.substring(0,i) + s.substring(i+1, len);
            String s_pre2 = s_pre + s_i;
            String s_new = s_pre2 + s_rem;
            // list.add(s_new);
            help(s_rem, s_pre2, list, map);
        }

    }
    public static void ss(String[] args) {
        //创建一个 HashMap 对象
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put(" ", hashmap.getOrDefault(" ", 0) + 1);
        //往hashmap中插入数据使用put()方法
        hashmap.put("数学", 78);
        hashmap.put("英语", 88);
        hashmap.put("语文", 86);
        //遍历hashmap，这个估计是大多数人都不会的
        for (Map.Entry<String, Integer> item : hashmap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
		/*   以下上面遍历的是输出
		 数学 78
		语文 86
		英语 88
		 */
        // 通过上面的遍历我们可以知道hashmap中以及存在了上述数据
        // 下面在来插入一个数据看看会有什么不同
        hashmap.put("语文", 100);
        for (Map.Entry<String, Integer> item : hashmap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
		/*    通过下面我们可以看到语文的成绩变成了100，原来的86没有了，这就说明在 HashMap 中，key 的值不能重复，如果存在重复值，则后面的值会把前面的值给覆盖掉
		 数学 78
		语文 100
		英语 88
		*/

        // 我们可以用 containskey()方法来判断里面是否存在某个key
        if (hashmap.containsKey("数学"))
            System.out.println("存在key=数学");
        else
            System.out.println("不存在该key=数学");
    }

}

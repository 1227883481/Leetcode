package experience;

import java.util.*;

/**
 * @author wgl
 * @create 2021-09-23 20:36
 */
public class MyTest3 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.size());
        System.out.println(list.peek());
        list.add(2);
        list.add(3);
        System.out.println(list.peek());
        System.out.println(list.peekLast());
        System.out.println("*******null,null,2,3");
        list.offer(null);
        list.offer(null);
        System.out.println(list.size());
        System.out.println(list.peekLast());
        List<Integer> listSyn = Collections.synchronizedList(list);
    }
}

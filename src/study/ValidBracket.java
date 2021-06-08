package study;

import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import javax.xml.ws.RequestWrapper;
import java.util.*;

/**
 * @author wgl
 * @create 2021-04-26 10:33
 */
public class ValidBracket {

    public static void main(String[] args) {
        ValidBracket validBracket = new ValidBracket();
        validBracket.isValid("()");
    }
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                char cc = stack.pop();
                if (cc == '(') {
                    continue;
                } else {
                    return false;
                }
            }
            if (c == ']') {
                char cc = stack.pop();
                if (cc == '[') {
                    continue;
                } else {
                    return false;
                }
            }
            if (c == '}') {
                char cc = stack.pop();
                if (cc == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0 || stack.peek() == null) {
            return true;
        }
        return false;
    }

    @Test
    public void test () {
        Character cc = new Character('g');
        System.out.println(cc == 'g');
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList();
        for (int i : nums) {
            list.add(i);
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if (i != list.get(i)) {
                return i;
            }
        }
        return len;
    }

    @Test
    public void test1() {
        Integer i = 3;
        int j = 1;
        if (i == j) {
            System.out.println("1111");
        }
    }

    @Test
    public void test2 ()
    {
        int[] a = new int[] {1,2,3,4,5};
//        Integer[] b = (Integer[]) a;
        System.out.println(Arrays.toString(a));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
//        System.out.println(list.size());

        Integer[] arrs = new Integer[list.size()];
        System.out.println(Arrays.toString(arrs));
        list.toArray(arrs);
        System.out.println(arrs.getClass());
//        System.out.println(Arrays.toString(arrs));

//        Integer[] b = (Integer[]) list.toArray();
//        list =  Arrays.asList(a);
//        System.out.println(list.toString());
//        System.out.println(Arrays.toString(b));

//        for ( Object i : list) {
//            System.out.println(list.toString());
//        }
    }
}

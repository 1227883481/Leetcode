package labuladong;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wgl
 * @create 2021-07-16 16:34
 */
public class lc567 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        if (stack.isEmpty()) {
            System.out.println("空");
        } else {
            System.out.println(stack.pop());
        }
        Deque deque = new ArrayDeque();
    }
    public int[] rob() {

        return new int[2];

    }
}

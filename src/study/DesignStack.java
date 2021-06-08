package study;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wgl
 * @create 2021-04-25 14:20
 */
public class DesignStack {
    Deque<Integer> deque;
    /** initialize your data structure here. */
    public DesignStack() {
        deque = new ArrayDeque<Integer>();
    }

    public void push(int val) {
        deque.push(val);
    }

    public void pop() {
        deque.poll();
    }

    public int top() {
        int peek = deque.peek();
        Integer.toString(5);
        return peek;
    }

    public int getMin() {
        int min = deque.peek();

        for (Integer i : deque) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

}

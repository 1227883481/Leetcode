package offer;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author wgl
 * @create 2021-05-16 13:24
 */
public class offer030 {
    public static void main(String[] args) {
        offer030 offer030 = new offer030();
        offer030.push(512);
        offer030.push(-1024);
        offer030.push(-1024);
        offer030.push(512);
        offer030.pop();
        System.out.println(offer030.min());
        offer030.pop();
        System.out.println(offer030.min());
        offer030.pop();
        System.out.println(offer030.min());

    }
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minValue = new Stack<>();
    /** initialize your data structure here. */
    public offer030() {
        stack = new Stack<>();
        minValue = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minValue.isEmpty()) {
            minValue.push(x);
        } else {
            int preMin = minValue.peek();
            if (preMin >= x) {
                minValue.push(x);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            // return null;
        } else {
            if (stack.peek() == minValue.peek()) {
                minValue.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int val = stack.peek();
            return val;
        }
    }

    public int min() {
        if (minValue.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int val = minValue.peek();
            return val;
        }
    }
}

package study;

import java.util.Stack;

/**
 * @author wgl
 * @create 2021-05-11 16:52
 */
class CQueue {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack0 = new Stack<Integer>();
    public CQueue() {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack0 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        // stack.push(value);
        int count = 0;
        while(stack0.empty() == false) {
            stack.push(stack0.pop());
            count++;
        }
        stack0.push(value);
        while(count != 0) {
            stack0.push(stack.pop());
        }
    }

    public int deleteHead() {
        if (stack0.empty() == true) {
            return -1;
        }
        return stack0.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
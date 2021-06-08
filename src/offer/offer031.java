package offer;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author wgl
 * @create 2021-05-16 15:39
 */
public class offer031 {
    public static void main(String[] args) {
        offer031 offer031 = new offer031();
        int[] pushed = new int[]{1,2,3,4,5,6,7};
        int[] poped = new int[]{5,4,3,2,1,6,7};
        System.out.println(offer031.validateStackSequences(pushed, poped));
     }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int val : pushed) {
            //pushed数组中的元素逐个压栈
            stack.push(val);
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
    @Test
    public void test() {
        System.out.println(("" + 'c').getClass());
    }
}

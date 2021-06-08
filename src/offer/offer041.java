package offer;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.nio.channels.Pipe;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author wgl
 * @create 2021-06-08 10:46
 */
public class offer041 {
    public static void main(String[] args) {
        offer041 offer041 = new offer041();
        offer041.method6(new test() {
            @Override
            public int method2(int x, int y) {
                return 0;
            }
        });
        offer041.method6((x, y) -> (x - y));
    }
    public void method6(test t) {
//        System.out.println("111");
        System.out.println(t.method2(1, 2));
    }
}

interface test {
//    void method1();
    int method2(int x, int y);
    default void method3() {
        System.out.println("2222");
    }

}



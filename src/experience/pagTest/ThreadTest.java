package experience.pagTest;

import org.junit.jupiter.api.Test;
import sun.awt.windows.ThemeReader;

import java.lang.annotation.Target;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.FutureTask;

/**
 * @author wgl
 * @create 2021-09-14 10:40
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            System.out.println("FutureTask类");
            return 100;
        });
        new Thread(task3, "t3").start();

        System.out.println(task.getClass());
        Thread t1 = new Thread(task, "t1");
        t1.start();
        System.out.println(t1.getName());
        System.out.println(t1.getClass());
    }


    @Test
    public void test1() {


    }

}

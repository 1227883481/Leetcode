package experience;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wgl
 * @create 2021-08-14 17:13
 */
public class ThreadPool {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> blk = new ArrayBlockingQueue<>(5);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,1000, blk,);
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
        ClassLoader myClassLoader = new ClassLoader() {



        };

    }
}



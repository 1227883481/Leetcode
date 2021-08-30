package experience;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wgl
 * @create 2021-08-16 11:02
 */
public class PriorityQueueTest {
    Queue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);
}

package hot;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wgl
 * @create 2021-07-05 22:34
 */
public class hot148 {
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        ListNode cur = head;
        while (cur != null) {
            heap.add(cur);
            cur = cur.next;
        }
        ListNode res = heap.poll();
        cur = res;
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
}

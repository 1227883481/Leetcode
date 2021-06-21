package hot;

/**
 * @author wgl
 * @create 2021-06-21 21:57
 */
public class hot142 {
    public static void main(String[] args) {

    }
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            if (fast.next != null) {
                fast = fast.next.next;
            }
            slow = slow.next;
            int count = 1;
            while (fast != slow) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
                count++;
            }
            fast = head;
            slow = head;
            for (int i = 0; i < count; i++) {
                fast = fast.next;
            }

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}

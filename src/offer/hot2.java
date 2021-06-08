package offer;

/**
 * @author wgl
 * @create 2021-06-07 23:02
 */
public class hot2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ge = 0;
        int shi = 0;
        int sum = l1.val + l2.val + shi;
        ListNode head = new ListNode(sum % 10);
        ListNode res = head;
        shi = sum / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + shi;
            ge = sum % 10;
            ListNode node = new ListNode(ge);
            res.next = node;
            res = res.next;
            shi = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            sum = l2.val + shi;
            ge = sum % 10;
            ListNode node = new ListNode(ge);
            res.next = node;
            res = res.next;
            shi = sum / 10;
            l2 = l2.next;
        }
        if (l1 != null) {
            sum = l1.val + shi;
            ge = sum % 10;
            ListNode node = new ListNode(ge);
            res.next = node;
            res = res.next;
            shi = sum / 10;
            l1 = l1.next;
        }
        if (shi == 0) {
            return head;
        } else {
            ListNode node = new ListNode(shi);
            res.next = node;
            return head;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

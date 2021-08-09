package git;

/**
 * @author wgl
 * @create 2021-08-09 10:55
 */
public class MergeK_Linklist {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        for (int i = 1; i < n; i = i * 2) {
            for (int start = 0; start < n; start = start + 2 * i) {
                if (start + i >= n) {
                    break;
                }
                ListNode head1 = lists[start];
                ListNode head2 = lists[start + i];
                ListNode head = new ListNode(0);
                ListNode cur1 = head1;
                ListNode cur2 = head2;
                ListNode cur = head;
                while (cur1 != null && cur2 != null) {
                    if (cur1.val < cur2.val) {
                        cur.next = cur1;
                        cur1 = cur1.next;
                    } else {
                        cur.next = cur2;
                        cur2 = cur2.next;
                    }
                    cur = cur.next;
                }
                if (cur1 == null) {
                    cur.next = cur2;
                } else {
                    cur.next = cur1;
                }
                lists[start] = head.next;
            }
        }
        return lists[0];
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

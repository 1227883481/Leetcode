package labuladong;



/**
 * @author wgl
 * @create 2021-07-24 23:08
 * K个一组反转链表
 */
public class ReverseLinkAGroupOfK {
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
    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 1) {
                return head;
            }
            //统计有多少个节点
            int num = 0;
            ListNode temp = head;
            while (temp != null) {
                num++;
                temp = temp.next;
            }


            ListNode cur = head;
            ListNode pre = null;
            ListNode res = null;
            for (int i = 0; i + k <= num; i = i + k) {//只起计数的作用，没有处理的意义
                if (i == 0) {
                    ListNode partHead = head;
                    ListNode partPre = null;
                    for (int j = 0; j < k; j++) {
                        ListNode next = cur.next;
                        cur.next = partPre;
                        partPre = cur;
                        cur = next;
                    }
                    res = partPre;
                    pre = head;
                    pre.next = cur;
                    continue;
                }

                //当不是第一段的时候这么处理
                ListNode partHead = cur;
                ListNode partPre = null;
                for (int j = 0; j < k; j++) {
                    ListNode next = cur.next;
                    cur.next = partPre;
                    partPre = cur;
                    cur = next;
                }

                partHead.next = cur;
                pre.next = partPre;
                pre = partHead;

            }
            return res;
        }
    }
}

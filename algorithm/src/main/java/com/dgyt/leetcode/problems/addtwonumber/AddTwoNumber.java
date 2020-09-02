package com.dgyt.leetcode.problems.addtwonumber;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumber {

    /**
     * 我的答案
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode pre = new ListNode();
        while ((l1 != null && l2 != null)) {
            if (pre.val >= 10) {
                cur.val = l1.val + l2.val + 1;
                pre.val = pre.val - 10;
            } else {
                cur.val = l1.val + l2.val;
            }
            pre = cur;
            cur = new ListNode();
            pre.next = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1 size != l2 size
        if (l1 != null || l2 != null) {
            cur = l1 == null ? l2 : l1;
            pre.next = cur;
            while (cur != null && pre.val >= 10) {
                cur.val = cur.val + 1;
                pre.val = pre.val - 10;
                pre = cur;
                cur = cur.next;
            }
            if (cur == null && pre.val >= 10) {
                cur = new ListNode();
                pre.next = cur;
                pre.val = pre.val - 10;
                cur.val = 1;
            }
        } else {

            if (pre.val >= 10) {
                cur.val = 1;
                pre.val = pre.val - 10;
            } else {
                pre.next = null;
            }

        }


        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

package day1.add_two_numbers;

public class Solution {
    /**
     * 54ms
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode cursor = head;
        int carry = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            int val1;
            int val2;
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
            }
            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
            }
            cursor.next = new ListNode((val1 + val2 + carry) % 10);
            carry = (val1 + val2 + carry) / 10;
            cursor = cursor.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }

        return head;
    }
}

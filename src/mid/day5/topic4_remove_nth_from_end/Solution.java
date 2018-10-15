package mid.day5.topic4_remove_nth_from_end;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode cursor = head; // fast cursor
        ListNode targetPrev = null; // slow cursor, it should point to the previous node of the target to be deleted.
        int offset = 0; // the offset between fast cursor and slow cursor
        int length = 0; // the length of given list
        do {
            if (offset == n) {
                if (targetPrev == null) {
                    targetPrev = head;
                } else {
                    targetPrev = targetPrev.next;
                }
            } else {
                offset++;
            }

            cursor = cursor.next;
            length++;
        } while (cursor != null);

        if (n > length) {
            return head;
        }

        if (n == length) {
            return head.next;
        }

        if (targetPrev != null) {
            targetPrev.next = targetPrev.next.next;
        }

        return head;
    }

    private int length = 0;

    public ListNode removeNthFromEnd_best(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        helper(node, 0, n);
        return node.next;
    }

    private void helper(ListNode node, int index, int n) {
        if (node.next == null) {
            length = index;
            return;
        }
        helper(node.next, index + 1, n);
        if (index == length - n)
            node.next = node.next.next;
    }
}

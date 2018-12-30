package topic24_swap_pairs;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // swap first pair
        ListNode first = head;
        ListNode second = first.next;
        ListNode next = second.next;
        second.next = first;
        first.next = next;
        head = second;

        ListNode prev = first;
        first = first.next;
        int offset = 0;
        while (first != null) {
            if (offset == 1) {
                if (prev == null) {
                    prev = head;
                } else {
                    prev = prev.next.next;
                }
            } else {
                offset++;
            }

            swap(prev, first);

            first = first.next;
        }

        return head;
    }

    private void swap(ListNode prev, ListNode first) {
        ListNode second = first.next;
        if (second == null) return;
        ListNode next = second.next;

        if (prev == null) {
            second.next = first;
            first.next = next;
        } else {
            prev.next = second;
            second.next = first;
            first.next = next;
        }
    }

    /* ==================== Best ==================== */
    public ListNode swapPairs_best(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode result = head.next;
            ListNode tmp = head.next.next;
            head.next.next = head;
            head.next = swapPairs(tmp);
            return result;
        }
    }
}

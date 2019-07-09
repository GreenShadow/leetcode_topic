package topic21_merge_two_lists;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1.next != null || c2.next != null) {
            if (c1.val < c2.val) {
            }
        }
        return null;
    }

    private void append(ListNode target, ListNode l) {
        if (target == null) {
            target = l;
        } else {
            target.next = l;
            target = target.next;
        }
    }
}

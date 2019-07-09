package topic21_merge_two_lists;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode tmp = this;
        while (true) {
            sb.append(tmp.val);
            tmp = tmp.next;
            if (tmp == null) {
                break;
            }
            sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public String toString() {
        return "val = " + val + ", has next = " + (next != null);
    }
}

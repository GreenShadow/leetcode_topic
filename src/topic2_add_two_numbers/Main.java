package topic2_add_two_numbers;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = create(1);
        ListNode l2 = create(9, 9);

        Solution s = new Solution();

        System.out.println(list2String(s.addTwoNumbers(l1, l2)));
    }

    private static ListNode create(int... inputs) {
        ListNode head = null;
        ListNode last = null;
        ListNode tmp = null;
        for (int i : inputs) {
            tmp = new ListNode(i);
            if (head == null) {
                head = tmp;
                last = head;
            } else {
                last.next = tmp;
                last = tmp;
            }
        }
        return head;
    }

    private static String list2String(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (head != null) {
            sb.append(head.val);
            sb.append(", ");
            head = head.next;
        }
//        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
}

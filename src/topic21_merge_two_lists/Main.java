package topic21_merge_two_lists;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode test1 = create(1, 2, 4);
        ListNode test2 = create(1, 2, 4);

        long start = System.currentTimeMillis();
        ListNode head = s.mergeTwoLists(test1, test2);
        long end = System.currentTimeMillis();
        System.out.println(head != null ? head.toFullString() : "[]");
        System.out.println("time = " + (end - start));
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
}

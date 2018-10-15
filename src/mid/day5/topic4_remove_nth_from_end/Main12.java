package mid.day5.topic4_remove_nth_from_end;

public class Main12 {
    public static void main(String[] args) {
        Solution s = new Solution();

//        ListNode test = create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        int n = 2;

//        ListNode test = create(1);
//        int n = 1;

//        ListNode test = create(1, 2);
//        int n = 2;

        ListNode test = create(1);
        int n = 1;

        long start = System.currentTimeMillis();
        ListNode head = s.removeNthFromEnd(test, n);
        long end = System.currentTimeMillis();
        System.out.println(head != null ? head.toFullString() : "[]");
        System.out.println("time = " + (end - start));

//        long start = System.currentTimeMillis();
//        System.out.println("Answer = " + s.threeSumClosest(test, target));
//        long end = System.currentTimeMillis();
//        System.out.println("Time = " + (end - start));
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

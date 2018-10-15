package mid.day7.topic1_swap_pairs;

public class Main13 {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode test = create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long start = System.currentTimeMillis();
        ListNode result = s.swapPairs(test);
        long end = System.currentTimeMillis();
        System.out.println(result == null ? "null" : result.toFullString());
        System.out.println("time = " + (end - start));
    }

    private static ListNode create(int... inputs) {
        ListNode head = null;
        ListNode last = null;
        ListNode tmp;
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

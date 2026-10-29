package D29_10_2026;


public class LeetCode19 {

    // Cấu trúc một nút trong danh sách liên kết
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode fast = dummy;
            ListNode slow = dummy;

            // Đưa fast đi trước slow n + 1 bước
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            // Di chuyển đồng thời hai con trỏ
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // Xóa nút thứ n tính từ cuối
            slow.next = slow.next.next;

            return dummy.next;
        }
    }

    // In danh sách liên kết
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        Solution solution = new Solution();
        head = solution.removeNthFromEnd(head, n);

        printList(head);
    }
}

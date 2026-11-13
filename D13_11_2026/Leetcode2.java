package D13_11_2026;



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Node giả
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Số nhớ
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Cộng giá trị của l1
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Cộng giá trị của l2
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Tính số nhớ
            carry = sum / 10;

            // Tạo node mới
            current.next = new ListNode(sum % 10);

            // Di chuyển current
            current = current.next;
        }

        return dummy.next;
    }
}

public class Leetcode2 {

    // Chuyển mảng thành Linked List
    public static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    // In Linked List
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

        Solution solution = new Solution();

        // Input
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});

        // Gọi hàm xử lý
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Output
        System.out.print("Result: ");
        printList(result);
    }
}

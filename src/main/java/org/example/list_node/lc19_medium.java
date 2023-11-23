package org.example.list_node;

public class lc19_medium {
    public static void main(String[] args) {
        ListNode listNode = createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode result = solution1117(listNode, 2);
        printLinkedList(result);
    }

    public static ListNode solution1117(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode current = head;
        ListNode temp = current;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            temp = temp.next;
            current = current.next;
            pre = pre.next;
        }
        pre.next = current.next;
        return dummy.next;
    }


    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline for better formatting
    }
}

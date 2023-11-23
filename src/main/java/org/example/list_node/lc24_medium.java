package org.example.list_node;

public class lc24_medium {
    public static void main(String[] args) {
        ListNode listNode = createLinkedList(new int[]{1, 2, 3, 4,5,6,7});
        ListNode result = solution1117(listNode);
        printLinkedList(result);
    }

    public static ListNode solution1117(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = head;
        ListNode previous = dummy;
        while (previous.next != null && previous.next.next != null) {
            previous.next = current.next; // 0-2
            current.next = current.next.next; // 1-3
            previous.next.next = current; // 2-1
            previous = previous.next.next; // move 2 listNode
            current = current.next; // move 2 listNode
        }

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

package org.example.list_node;

public class lc206_easy {
    public static void main(String[] args) {

        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});
//        ListNode listNode = solution1116(head);
//        printLinkedList(listNode);
        ListNode listNode2 = solution1117(head);
        printLinkedList(listNode2);
    }

    private static ListNode solution1117(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode after;
        while (current != null) {
            after = current.next;
            current.next = previous;
            previous = current;
            current = after;
        }
        return previous;
    }

    private static ListNode solution1116(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
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

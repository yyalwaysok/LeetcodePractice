package org.example.list_node;

public class lc203_easy {
    // Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val = 6;
        ListNode listNode = solution1116v2(head, val);
        printLinkedList(listNode);
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

    public static ListNode solution1116v2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode solution1116(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode previous = dummy;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current; // current ListNode should be kept, so update the current ListNode to be the previous ListNode and then move to check the one after that
            }
            current = current.next; // finish checking if current should be skipped, so we can move to the next one ListNode
        }
        return dummy.next;
    }

    public static ListNode solution1115(ListNode head, int value) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val == value) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return dummy.next;
    }
}

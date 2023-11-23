package org.example.list_node;

// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.
public class lc142_medium {
    public static void main(String[] args) {
        ListNode listNode = createLinkedList(new int[]{3, 2, 0, -4});
        ListNode result = solution1118(listNode);
        printLinkedList(result);
    }

    public static ListNode solution1118(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode meetNode2Pos = fast;
                ListNode head2Pos = head;
                while (meetNode2Pos != head2Pos) {
                    meetNode2Pos = meetNode2Pos.next;
                    head2Pos = head2Pos.next;
                }
                return meetNode2Pos;
            }
        }

        return null;
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

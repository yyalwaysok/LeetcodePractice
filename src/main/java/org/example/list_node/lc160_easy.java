package org.example.list_node;

public class lc160_easy {
    // Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
    // intersect. If the two linked lists have no intersection at all, return null.
    public static void main(String[] args) {
        ListNode listNodeA = createLinkedList(new int[]{1, 4, 5});
        ListNode listNodeB = createLinkedList(new int[]{3, 5, 4, 5});
        ListNode result = solution1118v2(listNodeA, listNodeB);
        printLinkedList(result);
    }

    // get the length of both nodelist and then move to the point where it's possible to be the intersecting place.
    public static ListNode solution1118v2(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        int lengthA = 0;
        while (currentA != null) {
            currentA = currentA.next;
            lengthA++;
        }
        ListNode currentB = headB;
        int lengthB = 0;
        while (currentB != null) {
            currentB = currentB.next;
            lengthB++;
        }
        currentA = headA;
        currentB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                currentB = currentB.next;
            }
        }
        while (currentA != null) {
            if (currentA == currentB) {
                return currentA;
            } else {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return null;
    }

    public static ListNode solution1118(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(0, headA);
        ListNode dummyB = new ListNode(0, headB);
        ListNode currentA = dummyA;

        while (currentA != null) {
            ListNode currentB = dummyB;
            while (currentB != null) {
                if (currentA == currentB) {
                    return currentA;
                } else {
                    currentB = currentB.next;
                }
            }
            currentA = currentA.next;

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

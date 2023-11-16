package org.example.list_node;

public class lc707_medium {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.printList();
        myLinkedList.addAtHead(1);
        myLinkedList.printList();
        myLinkedList.addAtHead(2);
        myLinkedList.printList();
        myLinkedList.addAtIndex(2,3);
        myLinkedList.printList();
        myLinkedList.deleteAtIndex(0);
        myLinkedList.printList();
    }
}

class MyLinkedList {
    int size; // number of the elements in linkedlist
    ListNode dummyHeadNode;

    public MyLinkedList() {
        size = 0;
        dummyHeadNode = new ListNode(); // placeholder, doesn't actually store any value, so the size is still count as 0
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode current = dummyHeadNode;
        for (int i = 0; i <= index; i++) { // +1 because exclude the dummy head node
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) { // index=size means adding at the end of the nodelist
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode current = dummyHeadNode; // create a pointer to locate the list-node before the adding point
        for (int i = 0; i < index; i++) {
            current = current.next; // move the pointer
        }
        ListNode toAdd = new ListNode(val);
        // the order can't be reversed. if so, you can't get the original current.next list-node
        toAdd.next = current.next;
        current.next = toAdd;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode current = dummyHeadNode; // pointer
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void printList() {
        ListNode current = dummyHeadNode.next; // Skip the dummy head node
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
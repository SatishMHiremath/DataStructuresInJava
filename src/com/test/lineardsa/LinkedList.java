package com.test.lineardsa;

public class LinkedList {

    private Node head;

    class Node {
        private int data;
        private Node next;
        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(10);
        linkedList.addNode(20);
        linkedList.addNode(30);
        linkedList.addNode(40);
        linkedList.printList();
        linkedList.deleteMiddleNode();
        linkedList.removeNode(20);
        linkedList.printList();

        linkedList.removeNodeAtPosition(2);
        linkedList.printList();

        linkedList.insertAtPosition(25, 2);
        linkedList.printList();

        linkedList.insertAtBeginning(100);
        linkedList.printList();

        linkedList.insertAtEnd(200);
        linkedList.printList();

        linkedList.reverseNode();
        linkedList.printList();
    }

    public ListNode oddEvenList(ListNode head) {
         if(head == null) {
             return null;
         }   
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while(even != null && even.next != null) {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next = evenHead;
        return head
    }
    private void printList() {
        Node curr = head;
        System.out.println("Linked List : ");
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    private Node deleteMiddleNode() { 
        if(head == null || head.next == null) { 
            return; 
            // No middle node to delete 
        }
        Node slow = head; 
        Node fast = head; 
        Node prev = null; 
        // Use two-pointer technique to find the middle node 
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            prev = slow; 
            slow = slow.next; 
        }
        // 'slow' is now pointing to the middle node 
        if (prev != null) { 
            prev.next = slow.next; 
            // Delete the middle node 
        }
        return head;
    }
    
    private void addNode(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    private void removeNode(int val) {
        if (head == null) return;

        if (head.data == val) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data != val) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    private void removeNodeAtPosition(int position) {
        if (head == null || position < 0) return;

        if (position == 0) {
            head = head.next;
            return;
        }

        Node curr = head;
        for (int i = 0; curr != null && i < position - 1; i++) {
            curr = curr.next;
        }

        if (curr == null || curr.next == null) return;

        curr.next = curr.next.next;
    }

    private void insertAtPosition(int val, int position) {
        Node newNode = new Node(val);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node curr = head;
        for (int i = 0; curr != null && i < position - 1; i++) {
            curr = curr.next;
        }

        if (curr == null) return;

        newNode.next = curr.next;
        curr.next = newNode;
    }

    private void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    private void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    private void reverseNode() {
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}

// Insertion in singly linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day17 {

    // insert at beginning
    static Node insertAtStart(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }

    // insert at end
    static Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);

        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // print list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head = insertAtStart(head, 10);
        head = insertAtEnd(head, 30);

        printList(head);
    }
}

// Floyd's algorithm to detect and remove cycle in linked list
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day26 {

    static void removeCycle(Node head) {
        Node slow = head, fast = head;
        boolean hasCycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return;

        // Move slow to head
        slow = head;

        // Find node before cycle start
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Break the cycle
        fast.next = null;
    }

    static void printList(Node head) {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // create cycle
        head.next.next.next.next = head.next;

        removeCycle(head);

        printList(head);
    }
}

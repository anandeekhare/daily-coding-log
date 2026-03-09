class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day25 {

    static Node getIntersection(Node headA, Node headB) {

        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {

        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(3);
        headA.next = new Node(7);
        headA.next.next = common;

        Node headB = new Node(99);
        headB.next = new Node(1);
        headB.next.next = common;

        Node intersection = getIntersection(headA, headB);

        if (intersection != null)
            System.out.println("Intersection at: " + intersection.data);
        else
            System.out.println("No intersection");
    }
}
// Find intersection node of two linked lists using pointer switching

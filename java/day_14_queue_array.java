class Queue {
    int front = 0, rear = -1, size = 0;
    int[] arr = new int[5];

    void enqueue(int x) {
        if (size == arr.length) {
            System.out.println("Queue Full");
            return;
        }
        arr[++rear] = x;
        size++;
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue Empty");
            return;
        }
        front++;
        size--;
    }

    void peek() {
        if (size == 0) {
            System.out.println("Empty queue");
        } else {
            System.out.println("Front: " + arr[front]);
        }
    }
}

public class Day14 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.peek();
        q.dequeue();
        q.peek();
    }
}

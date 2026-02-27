class CircularQueue {
    int[] arr = new int[5];
    int front = -1, rear = -1;

    void enqueue(int x) {
        if ((rear + 1) % arr.length == front) {
            System.out.println("Queue Full");
            return;
        }

        if (front == -1) front = 0;
        rear = (rear + 1) % arr.length;
        arr[rear] = x;
    }

    void dequeue() {
        if (front == -1) {
            System.out.println("Queue Empty");
            return;
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }
    }

    void peek() {
        if (front == -1) {
            System.out.println("Empty queue");
        } else {
            System.out.println("Front: " + arr[front]);
        }
    }
}

public class Day15 {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.peek();
        q.dequeue();
        q.peek();
    }
}

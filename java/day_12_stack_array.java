class Stack {
    int top = -1;
    int[] arr = new int[5];

    void push(int x) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        top--;
    }

    void peek() {
        if (top == -1) {
            System.out.println("Empty stack");
        } else {
            System.out.println("Top: " + arr[top]);
        }
    }
}

public class Day12 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.peek();
        s.pop();
        s.peek();
    }
}

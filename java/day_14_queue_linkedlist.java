import java.util.LinkedList;
import java.util.Queue;

public class QueueLL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.remove();
        System.out.println(q.peek());
    }
}

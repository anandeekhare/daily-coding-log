import java.util.PriorityQueue;

public class Day46 {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // smallest first
        }
    }
}

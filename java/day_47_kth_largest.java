import java.util.PriorityQueue;

public class Day47 {

    static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);

            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}

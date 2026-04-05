import java.util.*;

public class Day48 {

    static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // frequency count
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // min heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            result[i++] = pq.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] res = topKFrequent(nums, k);

        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}

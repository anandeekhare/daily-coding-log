import java.util.*;

public class Day59 {

    static boolean isCycle(int n, List<List<Integer>> adj) {

        int[] indegree = new int[n];

        // calculate indegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            count++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return count != n; // cycle exists
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // cycle

        System.out.println(isCycle(n, adj));
    }
}

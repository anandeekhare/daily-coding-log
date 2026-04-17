import java.util.*;

public class Day58 {

    static void topoSort(int n, List<List<Integer>> adj) {

        int[] indegree = new int[n];

        // calculate indegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // add nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topoSort(n, adj);
    }
}

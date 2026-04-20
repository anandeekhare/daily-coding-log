import java.util.*;

public class Day60 {

    static void shortestPath(int start, List<List<Integer>> adj, int n) {

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbor : adj.get(node)) {

                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        shortestPath(0, adj, n);
    }
}

import java.util.*;

class Pair {
    int node, wt;

    Pair(int n, int w) {
        node = n;
        wt = w;
    }
}

public class Day64 {

    static int prims(int n, List<List<Pair>> adj) {

        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.wt - b.wt
        );

        pq.add(new Pair(0, 0));

        int total = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            if (visited[curr.node]) continue;

            visited[curr.node] = true;
            total += curr.wt;

            for (Pair neighbor : adj.get(curr.node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.wt));
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1,2));
        adj.get(1).add(new Pair(0,2));

        adj.get(0).add(new Pair(3,6));
        adj.get(3).add(new Pair(0,6));

        adj.get(1).add(new Pair(2,3));
        adj.get(2).add(new Pair(1,3));

        adj.get(1).add(new Pair(3,8));
        adj.get(3).add(new Pair(1,8));

        adj.get(1).add(new Pair(4,5));
        adj.get(4).add(new Pair(1,5));

        adj.get(2).add(new Pair(4,7));
        adj.get(4).add(new Pair(2,7));

        System.out.println(prims(n, adj));
    }
}

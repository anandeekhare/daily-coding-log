import java.util.*;

class Edge {
    int u, v, wt;

    Edge(int a, int b, int c) {
        u = a;
        v = b;
        wt = c;
    }
}

public class Day62 {

    static void bellmanFord(int n, List<Edge> edges, int src) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // relax edges n-1 times
        for (int i = 1; i < n; i++) {

            for (Edge e : edges) {

                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.wt < dist[e.v]) {

                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        // check negative cycle
        for (Edge e : edges) {

            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.wt < dist[e.v]) {

                System.out.println("Negative cycle detected");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Distance to " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int n = 5;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,6));
        edges.add(new Edge(0,2,7));
        edges.add(new Edge(1,3,5));
        edges.add(new Edge(1,4,-4));
        edges.add(new Edge(2,3,-3));
        edges.add(new Edge(3,1,-2));

        bellmanFord(n, edges, 0);
    }
}

import java.util.*;

class Edge {
    int u, v, wt;

    Edge(int a, int b, int c) {
        u = a;
        v = b;
        wt = c;
    }
}

public class Day65 {

    static int[] parent = new int[100];

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    static int kruskal(int n, List<Edge> edges) {

        for (int i = 0; i < n; i++) parent[i] = i;

        edges.sort((a, b) -> a.wt - b.wt);

        int cost = 0;

        for (Edge e : edges) {

            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                cost += e.wt;
            }
        }

        return cost;
    }

    public static void main(String[] args) {

        int n = 4;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));

        System.out.println(kruskal(n, edges));
    }
}

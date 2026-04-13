import java.util.*;

class Pair {
    int node, parent;

    Pair(int n, int p) {
        node = n;
        parent = p;
    }
}

public class Day54 {

    static boolean isCycle(int n, List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, -1));
                visited[i] = true;

                while (!q.isEmpty()) {

                    Pair curr = q.poll();

                    for (int neighbor : adj.get(curr.node)) {

                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            q.add(new Pair(neighbor, curr.node));
                        }
                        else if (neighbor != curr.parent) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 4;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1); // cycle

        System.out.println(isCycle(n, adj));
    }
}

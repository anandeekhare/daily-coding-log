import java.util.*;

public class Day76 {

    static String alienOrder(String[] words, int k) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[k];

        // build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {

                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';

                    adj.get(u).add(v);
                    indegree[v]++;

                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.append((char)(node + 'a'));

            for (int neighbor : adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] words = {
            "baa",
            "abcd",
            "abca",
            "cab",
            "cad"
        };

        int k = 4;

        System.out.println(alienOrder(words, k));
    }
}

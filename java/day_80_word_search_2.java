import java.util.*;

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    String word;
}

public class Day80 {

    static TrieNode root = new TrieNode();

    static void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    static void dfs(char[][] board, int i, int j,
                    TrieNode node, List<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char ch = board[i][j];

        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i+1, j, node, result);
        dfs(board, i-1, j, node, result);
        dfs(board, i, j+1, node, result);
        dfs(board, i, j-1, node, result);

        board[i][j] = ch;
    }

    static List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };

        String[] words = {
            "oath","pea","eat","rain"
        };

        System.out.println(findWords(board, words));
    }
}

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

public class Day78 {

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

        node.isEnd = true;
    }

    static boolean startsWith(String prefix) {

        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return true;
    }

    public static void main(String[] args) {

        insert("apple");

        System.out.println(startsWith("app"));
        System.out.println(startsWith("bat"));
    }
}

import java.util.*;

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    List<String> suggestions = new ArrayList<>();
}

public class Day79 {

    static TrieNode root = new TrieNode();

    static void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];

            if (node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();

        TrieNode node = root;

        for (char ch : searchWord.toCharArray()) {

            int index = ch - 'a';

            if (node != null)
                node = node.children[index];

            if (node == null)
                result.add(new ArrayList<>());
            else
                result.add(node.suggestions);
        }

        return result;
    }

    public static void main(String[] args) {

        String[] products = {
            "mobile","mouse","moneypot","monitor","mousepad"
        };

        String searchWord = "mouse";

        System.out.println(
            suggestedProducts(products, searchWord)
        );
    }
}

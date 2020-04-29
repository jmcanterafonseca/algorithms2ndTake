package Chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *   Tries are prefix trees that allow to implement autocomplete features and the like
 *
 */
public class Trie {
    // Finds all the words with the prefix indicated as parameter
    // Null if the prefix is not found
    // List of 1 String with the prefix, means that the prefix has only a terminating node as adjacent child
    public List<String> find(TrieNode trie, String prefix) {
        List<String> out = new ArrayList<>();

        TrieNode current = trie;

        boolean prefixFound = true;

        for (int k = 0; k < prefix.length(); k++) {
            char c = prefix.charAt(k);

            if (trie.adjacent.get(c) != null) {
                current = trie.adjacent.get(c);
            } else {
                prefixFound = false;
                break;
            }
        }

        if (!prefixFound) {
            return out;
        }

        generate(current, new StringBuffer(prefix), out);

        return out;
    }

    // Generate all the words from a TrieNode
    private void generate(TrieNode node, StringBuffer buffer, List<String> words) {
        if (node.letter == '*') {
            words.add(buffer.toString());
            return;
        }

        for (char c : node.adjacent.keySet()) {
            buffer.append(c);
            generate(node.adjacent.get(c), buffer, words);
        }
    }

    // Builds a prefix tree
    public TrieNode buildTrie(List<String> wordList) {
        TrieNode root = new TrieNode(' ', new HashMap<>());

        for (String word : wordList) {
            TrieNode current = root;

            for (int k = 0; k < word.length(); k++) {
                char c = word.charAt(k);
                TrieNode next = current.adjacent.get(c);

                if (next == null) {
                    next = new TrieNode(c, new HashMap<>());
                    current.adjacent.put(c, next);
                }
                current = next;
            }
            // The terminating node has to be added
            current.adjacent.put('*', new TrieNode('*', null));
        }

        return root;
    }

    private static class TrieNode {
        public char letter;
        public Map<Character, TrieNode> adjacent;

        // The '*' character is used to mark a terminating node
        public TrieNode(char letter, Map<Character, TrieNode> adj) {
            this.letter = letter;
            this.adjacent = adj;
        }
    }

}

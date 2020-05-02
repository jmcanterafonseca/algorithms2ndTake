package Misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VanishCodes {

    public static int vanishCodes(List<String> codes, List<String> phoneNumbers) {
        int numCodes = 0;

        // Keypad configuration is set up
        Keypad keypad = new Keypad();

        // Trie is built
        TrieNode rootTrie = buildTrie(codes);

        for (String phoneNumber : phoneNumbers) {
            numCodes += vanishCodeFrom(rootTrie, keypad, rootTrie, phoneNumber.toCharArray(), 0);
        }

        return numCodes;
    }

    // Calculates the number of vanish codes starting from <start>
    private static int vanishCodeFrom(TrieNode rootTrie, Keypad keypad,
                                      TrieNode from, char[] input, int start) {

        // Have reached a terminal i.e. a vanish code
        if (from.nodeList.size() == 0) {
            return 1 + vanishCodeFrom(rootTrie, keypad, rootTrie, input, start);
        }

        if (start == input.length) {
            return 0;
        }

        char[] mappedChars = keypad.mapLetter(input[start]);

        if (mappedChars.length == 0) {
            return vanishCodeFrom(rootTrie, keypad, from, input, start + 1);
        }

        int total = 0;

        for (char c : mappedChars) {
            if (from.nodeList.get(c) != null) {
                total += vanishCodeFrom(rootTrie, keypad, from.nodeList.get(c), input, start + 1);
            }
        }

        return total;
    }

    // Builds the trie concerning the vanish codes
    private static TrieNode buildTrie(List<String> codes) {
        TrieNode rootTrie = new TrieNode();

        for (String s : codes) {
            TrieNode current = rootTrie;

            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);

                if (current.nodeList.get(c) == null) {
                    TrieNode cNode = new TrieNode();
                    current.nodeList.put(c, cNode);

                    current = cNode;
                } else {
                    current = current.nodeList.get(c);
                }
            }

        }

        return rootTrie;
    }

    private static class TrieNode {
        public Map<Character, TrieNode> nodeList = new HashMap<>();
    }

    // Keypad configuration. Check the way to managed ASCII codes.
    private static class Keypad {
        private Map<Character, char[]> keypad = new HashMap<>();

        public Keypad() {
            setupKeyPadMap();
        }

        private void setupKeyPadMap() {
            keypad.put('1', new char[0]);

            char[] letters = new char[4];
            for (int k = 0; k < 4; k++) {
                letters[k] = (char) ('P' + k);
            }
            keypad.put('7', letters);

            letters = new char[4];
            for (int k = 0; k < 4; k++) {
                letters[k] = (char) ('W' + k);
            }
            keypad.put('9', letters);

            int start = 'A';

            for (int c = '2'; c < '9'; c++) {
                if (c == '7') {
                    start += 4;
                    continue;
                }

                letters = new char[3];

                for (int k = 0; k < letters.length; k++) {
                    letters[k] = (char) (start + k);
                }

                keypad.put((char) c, letters);
                start += 3;
            }
        }

        public char[] mapLetter(char c) {
            char[] mappedChars = keypad.get(c);
            if (mappedChars == null) {
                mappedChars = new char[0];
            }

            return mappedChars;
        }
    }

}

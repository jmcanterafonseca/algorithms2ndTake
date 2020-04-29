package Misc;

import Chapter4.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquare_v2 {
/*
    public static List<List<String>> wordSquares(String[] words) {
        // First we build a Trie with all the words in the list
        // As the list can be huge we don't want to scan all words only those we know
        // are the ones that may fit
        Trie trie = new Trie();

        trie.buildTrie(Arrays.asList(words));

        List<List<String>> out = new ArrayList<>();

        for (int k = 0; k < words.length; k++) {
            List<String> square = new ArrayList<>();
            square.add(words[k]);

            makeSquares(square, trie, words[0].length(), out);
        }

        return out;
    }

    private static void makeSquares(List<String> status, Trie trie, int max, List<List<String>> squares) {
        if (!isSquare(status)) {
            return;
        }

        if (status.size() == max) {
            squares.add(status);
            return;
        }



        for (int k = 0; k < words.length; k++) {
            List<String> newStatus = new ArrayList<>(status);
            newStatus.add(words[k]);

            makeSquares(newStatus, words, squares);
        }
    }

    private static boolean isSquare(List<String> words) {
        // All the words are the same length
        int cols = words.get(0).length();
        int rows = words.size();

        int total = Math.min(rows, cols);

        for (int k = 0; k < total; k++) {
            for (int m = 0; m < total; m++) {
                if (words.get(k).charAt(m) != words.get(m).charAt(k)) {
                    return false;
                }
            }
        }

        return true;
    }
*/
}

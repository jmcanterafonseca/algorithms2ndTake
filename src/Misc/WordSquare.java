package Misc;

import java.util.ArrayList;
import java.util.List;

public class WordSquare {

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> out = new ArrayList<>();

        for (int k = 0; k < words.length; k++) {
            List<String> square = new ArrayList<>();
            square.add(words[k]);

            makeSquares(square, words, out);
        }

        return out;
    }

    private static void makeSquares(List<String> status, String[] words, List<List<String>> squares) {
        if (!isSquare(status)) {
            return;
        }

        if (status.size() == words[0].length()) {
            squares.add(status);
            return;
        }

        String prefix = new String(new char[]{status.get(0).charAt(status.size())});

        for (int k = 0; k < words.length; k++) {
            if (words[k].startsWith(prefix)) {
                List<String> newStatus = new ArrayList<>(status);
                newStatus.add(words[k]);
                makeSquares(newStatus, words, squares);
            }
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

}

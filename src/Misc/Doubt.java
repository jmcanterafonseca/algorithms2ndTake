package Misc;

import java.util.*;

public class Doubt {
    private static class Pair<F,S> {
        public F first;
        public S second;

        public Pair(F f, S s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.first, this.second);
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4};

        Arrays.sort(array, (value1, value2) -> 0);

        Map<Integer, Integer>[] m = new HashMap[3];

        System.out.println((124 / 1000) % 10);

        Pair<Integer, Integer> pair = new Pair<>(2, 4);
        Pair<Integer, Integer> pair2 = new Pair<>(2, 4);

        System.out.println(pair.hashCode());
        System.out.println(pair2.hashCode());
    }

    // (124 / divider) % 10
}

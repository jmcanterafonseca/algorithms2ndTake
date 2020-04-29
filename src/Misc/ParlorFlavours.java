package Misc;

import java.util.*;

public class ParlorFlavours {
    public static void whatFlavors(int[] cost, int money) {
        // We need to save original positions
        // For each cost the original position within the original cost array
        Map<Integer, List<Integer>> flavourPositions = new HashMap<>();

        for (int k = 0; k < cost.length; k++) {
            int c = cost[k];

            if (flavourPositions.get(c) == null) {
                flavourPositions.put(c, new ArrayList<Integer>());
            }

            flavourPositions.get(c).add(k);
        }

        // We sort the array in order to perform binary searches easier
        Arrays.sort(cost);

        // We start with half the money and see what happens
        int moneyIceCream1 = money / 2 + 1;
        int increment = -1;

        boolean flavorsCompleted = false;

        // This could also be an integer array of two elements
        List<Integer> result = new ArrayList<>();

        while (!flavorsCompleted) {
            int index1 = -1;
            while (index1 == -1 && moneyIceCream1 > 0 && moneyIceCream1 < money) {
                // Lets' try with a cheaper or more expensive one
                moneyIceCream1 += increment;
                index1 = searchElement(cost, moneyIceCream1);
            }
            if (index1 == -1) {
                moneyIceCream1 = (money / 2);
                increment = 1;
            } else {
                int index2 = searchElement(cost, money - moneyIceCream1);

                if (index2 != -1 && index2 != index1) {
                    flavorsCompleted = true;

                    result.add(index1);
                    result.add(index2);
                } else if (index2 == index1) {
                    // We check if there is a duplicate at the right or left
                    if (index2 + 1 < cost.length && cost[index2 + 1] == cost[index2]) {
                        index2 = index2 + 1;

                        flavorsCompleted = true;
                        result.add(index1);
                        result.add(index2);
                    }
                    if (index2 - 1 >= 0 && cost[index2 - 1] == cost[index2]) {
                        index2 = index2 - 1;
                        flavorsCompleted = true;
                        result.add(index1);
                        result.add(index2);
                    }
                }

            }
        }

        // We retrieve the corresponding indexes and sorted
        int[] finalResult = new int[2];
        finalResult[0] = flavourPositions.get(cost[result.get(0)]).get(0) + 1;
        finalResult[1] = flavourPositions.get(cost[result.get(1)]).get(0) + 1;

        if (finalResult[0] == finalResult[1]) {
            finalResult[1] = flavourPositions.get(cost[result.get(0)]).get(1) + 1;
        }

        Arrays.sort(finalResult);

        System.out.println(finalResult[0] + " " + finalResult[1]);

    }

    // Searches the element and returns the index (-1) if not found
    private static int searchElement(int[] cost, int element) {
        return binarySearch(cost, 0, cost.length - 1, element);
    }

    private static int binarySearch(int[] arr, int left, int right, int v) {
        if (left > right) {
            return -1;
        }

        int middle = left + ((right - left) / 2);

        if (arr[middle] < v) {
            return binarySearch(arr, middle + 1, right, v);
        } else if (arr[middle] > v) {
            return binarySearch(arr, left, middle - 1, v);
        } else {
            return middle;
        }
    }
}

package org.dhana.search;

import java.util.stream.IntStream;

public class TernarySearch {
    public int search(int[] numbers, int x, int low, int high) {
        if (high < low) {
            return -1;
        }

        int mid = low + (high - low) / 3;

        if (numbers[mid] == x) {
            return mid;
        }

        if (numbers[mid] < x) {
            return search(numbers, x, mid + 1, high);
        } else {
            return search(numbers, x, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        TernarySearch binarySearch = new TernarySearch();
        int[] numbers = IntStream.of(2, 4, 6, 8, 10, 33, 34, 66).toArray();
        int index = binarySearch.search(numbers, 34, 0, numbers.length -1);

        if (index == -1) {
            System.out.println("The number searched is not available.");
        } else {
            System.out.println("The number searched is available at index " + index);
        }
    }
}

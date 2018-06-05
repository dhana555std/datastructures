package org.dhana.search;

import java.util.stream.IntStream;

public class ExponentialSearch {
    public int search(int[] numbers, int low, int high, int ele) {
        if (numbers[0] > ele) {
            return -1;
        }

        if (numbers[0] == ele) {
            return 0;
        }

        int i = 1;
        while (i < numbers.length && numbers[i] <= ele) {
            i *= 2;
        }

        return new BinarySearch().search(numbers, ele, i/2, Math.min(i, numbers.length));
    }

    public static void main(String[] args) {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        int[] numbers = IntStream.of(2, 4, 6, 8, 10, 33, 34, 66).toArray();
        int index = exponentialSearch.search(numbers, 33, numbers.length -1, 33);

        if (index == -1) {
            System.out.println("The number searched is not available.");
        } else {
            System.out.println("The number searched is available at index " + index);
        }
    }
}

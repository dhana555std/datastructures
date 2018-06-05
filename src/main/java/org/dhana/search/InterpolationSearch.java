package org.dhana.search;

import java.util.stream.IntStream;

public class InterpolationSearch {
    public int search(int[] numbers, int ele, int low, int high) {
        if (high < low) {
            return -1;
        }

        int pos = low + ((high - low) / (numbers[high] - numbers[low])) * (ele - numbers[low]);

        if (numbers[pos] == ele) {
            return pos;
        } else if (ele > numbers[pos]) {
            return search(numbers, ele, pos + 1, numbers.length -1);
        } else {
            return search(numbers, ele, low, pos -1);
        }
    }

    public static void main(String[] args) {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] numbers = IntStream.of(2, 4, 6, 8, 10, 33, 34, 66).toArray();
        int index = interpolationSearch.search(numbers, 33, 0, numbers.length -1);

        if (index == -1) {
            System.out.println("The number searched is not available.");
        } else {
            System.out.println("The number searched is available at index " + index);
        }
    }
}

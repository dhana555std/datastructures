package org.dhana.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
    public int[] sort(int[] numbers) {
        boolean alreadySorted;

        for (int i = 0; i < numbers.length - 1; i++) {
            alreadySorted = true;
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    alreadySorted = false;
                }
            }

            if (alreadySorted) {
                System.out.println("Breaking at iteration " + (i+1));
                break;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] numbers = IntStream.of(39, 25, 12, 2, 11).toArray();
        System.out.println("Numbers are as follows:-");

        Arrays.stream(numbers).forEach(System.out::println);
        sort.sort(numbers);

        System.out.println("The sorted array is follows:-");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}

package org.dhana.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {

    public void sort(int[] numbers, int low, int high) {
        if (low < high) {
            int pivot = getPivot(numbers, low, high);
            sort(numbers, low, pivot - 1);
            sort(numbers, pivot + 1, high);
        }
    }

    private int getPivot(int[] numbers, int low, int high) {
        int i = low -1;
        int j = low;

        int pivot = numbers[high];

        while (j < high) {
            if (numbers[j] <= pivot) {
                ++i;
                swap(numbers, i, j);
            }

            j++;
        }

        swap(numbers, i + 1, high);

        return i + 1;

    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
//        int[] numbers = IntStream.of(39, 25, 12, 2, 11).toArray();
        int[] numbers = IntStream.of(10, 25, 12, 2, 11).toArray();
        System.out.println("Numbers are as follows:-");

        Arrays.stream(numbers).forEach(System.out::println);
        sort.sort(numbers, 0, numbers.length -1);

        System.out.println("The sorted array is follows:-");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}

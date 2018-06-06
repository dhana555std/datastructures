package org.dhana.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {
    public void sort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sort(numbers, low, middle);
            sort(numbers, middle + 1, high);
            merge(numbers, low, high, middle);
        }
    }

    private void merge(int[] numbers, int low, int high, int middle) {
        int leftArrayLength = middle - low + 1;
        int[] left = new int[leftArrayLength];

        int rightArrayLength = high - middle;
        int[] right = new int[rightArrayLength];

        for (int i = 0; i < left.length; i++) {
            left[i] = numbers[low + i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = numbers[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < leftArrayLength && j < rightArrayLength) {
            numbers[k] = (left[i] <= right[j]) ? left[i++] : right[j++];
            k++;
        }

        while (i < leftArrayLength) {
            numbers[k++] = left[i++];
        }

        while (j < rightArrayLength) {
            numbers[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] numbers = IntStream.of(2, 32, 44, 12, 87, 65, 54, 90, 32, 11, 23, 67, 21, 9, 1).toArray();
        mergeSort.sort(numbers, 0, numbers.length - 1);

        System.out.println("sorted array:-");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}

package org.dhana.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SelectionSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] numbers = IntStream.of(64, 25, 12, 22, 11).toArray();
        System.out.println("Numbers are as follows:-");

        Arrays.stream(numbers).forEach(System.out::println);
        sort.sort(numbers);

        System.out.println("The sorted array is follows:-");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}

package org.dhana.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSort {
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }

        return nums;
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] numbers = IntStream.of(64, 25, 12, 22, 11).toArray();
        System.out.println("Numbers are as follows:-");

        Arrays.stream(numbers).forEach(System.out::println);
        sort.sort(numbers);

        System.out.println("The sorted array is follows:-");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}

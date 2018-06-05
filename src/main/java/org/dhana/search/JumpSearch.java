package org.dhana.search;

import java.util.stream.IntStream;

public class JumpSearch {
    public int search(int[] numbers, int ele) {
        int jumpIndex = (int) Math.floor(Math.sqrt(numbers.length));

        int i = 0;
        if (ele < numbers[0]) {
            return -1;
        }

        while (i < numbers.length - 1) {
            if (ele < numbers[i]) {
                int k = i - jumpIndex + 1;
                while (k < i) {
                    if (numbers[k] == ele) {
                        return k;
                    }
                    k++;
                }
                return -1;
            } else if (ele == numbers[i]) {
                return i;
            } else if ((i + jumpIndex) > numbers.length - 1) {
                ++i;
                while (i <= numbers.length - 1) {
                    if (numbers[i] == ele) {
                        return i;
                    }
                    i++;
                }
            } else {
                i = i + jumpIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        int[] numbers = IntStream.range(1, 101).toArray();
        int index = jumpSearch.search(numbers, 77);

        if (index == -1) {
            System.out.println("The number searched is not available.");
        } else {
            System.out.println("The number searched is available at index " + index);
        }
    }
}

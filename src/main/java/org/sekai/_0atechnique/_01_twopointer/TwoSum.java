package org.sekai._0atechnique._01_twopointer;

import java.util.Arrays;

public class TwoSum {

    // left and right is two pointer technique
    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        Arrays.sort(arr); // n log n
        while (left < right) { // log n based 2
            int result = arr[left] + arr[right];

            if (result == target) {
                return new int[]{left, right};
            }

            if (result > target) {
                right --;
            } else {
                left ++;
            }
        }

        return new int[2];
    }

}

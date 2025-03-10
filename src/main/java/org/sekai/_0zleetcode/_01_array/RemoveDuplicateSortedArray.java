package org.sekai._0zleetcode._01_array;

import java.lang.reflect.Array;
import java.util.Arrays;

class RemoveDuplicateSortedArraySolution {

    // slow and fast two pointer
    public int removeDuplicates(int[] nums) {
        int count = 1;

        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {

                left = right;
                right++;

                nums[count] = nums[left];
                count++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return count;
    }

    public int removeDuplicateCleanWay(int[] nums) {
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }

}

public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {
        int[] data = new int[]{0,0,1,1,1,2,2,3,3,4};

        RemoveDuplicateSortedArraySolution solution = new RemoveDuplicateSortedArraySolution();
        int count = solution.removeDuplicates(data);
        System.out.println(count);

    }

}

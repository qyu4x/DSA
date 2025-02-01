package org.sekai._01_time_space_complexity;

// time complexity with O is worst case time.

import java.util.List;

public class TimeComplexity {
    // O(1)
    // O(log n) -> 2 log 8 = 3 from 2^3 = 8
    // O(n) -> O(n^2) -> O(n^3)

    public static void constantTimeComplexity(int a, int b) {
        if (a > b) { // constant O(1)
            System.out.println("constant time complexity");
        }
    }

    public static void linearTimeComplexity(int n) {
        for (int i = 0; i < n; i++) { // linear -> O(n)
            System.out.println("linear time complexity");
        }

        for (int i = 0; i < n; i++) { // linear -> O(n)
            System.out.println("linear time complexity");
        }

        // the time complexity is O(n) + O(n) = O(2n), remove constant because constant don't affect anything
        // O(n)
    }

    public static void linear2TimeComplexity(int n) {
        for (int i = 0; i < n; i++) { // linear -> O(n)
            System.out.println("linear time complexity");
            for (int j = 0; j < n; j++) { // linear -> O(n)
                System.out.println("linear time complexity");
            }
        }

        // O(n) * O(n) = O(n^2)

        for (int i = 0; i < n; i++) { // linear -> O(n)
            System.out.println("linear time complexity");
        }

        // the time complexity is O(n^2) + O(n) = O(2n^2), remove constant because constant don't affect anything
        // O(n^2)
    }

    public static int logNTimeComplexity(int target, int[] sortedData) { // devide and conquer
        int l = sortedData[0];
        int r = sortedData[sortedData.length - 1];

        while (l <= r) {
            int mid = l + (r - l) / 2; // devide into 2; if the  value is 8 : 8/2 -> 4/2 -> 2/2 -> 1, just 3 step
            if (sortedData[mid] == target) {
                return mid;
            }

            if (target > sortedData[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

}

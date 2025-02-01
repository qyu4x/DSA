package org.sekai._01_time_space_complexity;

public class SpaceComplexity {

    // O(n): create empty and put the value until n is O(n)
    // O(1): access value inside the array with index is linear
    // recursion is o(n): function is inside stack
    // just call the function is: O(1) cause don't need  extra memory


    public static int oNSpaceComplexity(int n) {
        if (n == 0) {
            return 0;
        }

        return n + oNSpaceComplexity(n-1); // O(n)
    }

    public static int o1SpaceComplexity(int a, int b) {
        int value = 0;
        for (int i = 0; i < 100; i++) {
            value += sum(a, b); // space complexity of this is O(1)
        }

        return value;
    }

    public static int sum(int a,  int b) {
        return a + b;
    }

}

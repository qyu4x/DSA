package org.sekai._0atechnique._01_twopointer;

public class Palindrome {

    public static boolean palindrome(String kata) {
        int left = 0;
        int right = kata.length() - 1;

        while (left <= right) {
            if (kata.charAt(left) != kata.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}

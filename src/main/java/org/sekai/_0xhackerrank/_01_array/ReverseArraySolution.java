package org.sekai._0xhackerrank._01_array;

import java.util.ArrayList;
import java.util.List;

class ReverseArray {

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> result = new ArrayList<>();
        // Write your code here
        for (int i = a.size() - 1; i >= 0; i--) {
            result.add(a.get(i));
        }
        return result;
    }

    public static List<Integer> reverseArrayBetter(List<Integer> a) {
        for (int i = 0; i < a.size() / 2; i++) {
            int temp = a.get(i);
            a.set(i, a.get(a.size() - 1 - i));
            a.set(a.size() - 1 - i, temp);
        }

        return a;
    }

}

public class ReverseArraySolution {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);

        List<Integer> rs = ReverseArray.reverseArrayBetter(data);
        System.out.println(rs);

    }
}



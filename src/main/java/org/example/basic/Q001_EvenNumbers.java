package org.example.basic;

import java.util.List;

public class Q001_EvenNumbers {
    public static void main(String[] args) {
        /*
         * Problem:
         * Given a list of integers, filter out even numbers using Java Streams.
         *
         * Input:
         * [1, 2, 3, 4, 5, 6]
         *
         * Output:
         * [2, 4, 6]
         */

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> ans = numbers.stream()
                .filter(num -> num % 2==0)
                .toList();

        System.out.println(ans);
    }
}

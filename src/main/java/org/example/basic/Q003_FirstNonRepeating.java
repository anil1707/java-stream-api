package org.example.basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q003_FirstNonRepeating {
    /*
     * Problem:
     * Given a list of integers, find the first non-repeating element using Java Streams.
     *
     * Input:
     * [4, 5, 1, 2, 0, 4, 5, 2]
     *
     * Output:
     * 1
     */

    public static void main(String[] args) {
        List<Integer> list = List.of(4, 5, 1, 2, 0, 4, 5, 2);

        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        Integer ans = list.stream()
                .filter(num -> map.get(num) == 1)
                .findFirst()
                .orElse(null);

        System.out.println(ans);

    }
}

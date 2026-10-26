package org.example.intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q004_CountOccurrences {
    /*
     * Problem:
     * Given a list of strings, count the occurrences of each string using Java Streams.
     *
     * Input:
     * ["apple", "banana", "apple", "orange", "banana", "apple"]
     *
     * Output:
     * {apple=3, banana=2, orange=1}
     */

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> ans = list.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        ans.forEach((fruit, count) ->{
            System.out.println(fruit + "-> " + count);
        });
    }
}

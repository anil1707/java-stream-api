package org.example.intermediate;

import java.util.Comparator;
import java.util.List;

public class Q007_SortByLength {
    /*
     * Problem:
     * Given a list of strings, sort them by their length in ascending order using Java Streams.
     *
     * Input:
     * ["apple", "kiwi", "banana", "fig"]
     *
     * Output:
     * ["fig", "kiwi", "apple", "banana"]
     */
    public static void main(String[] args) {
        List<String> list = List.of("apple", "kiwi", "banana", "fig");
        List<String> ans = list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(ans);
    }
}

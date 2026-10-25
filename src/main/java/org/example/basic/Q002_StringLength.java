package org.example.basic;

import java.util.ArrayList;
import java.util.List;

public class Q002_StringLength {
    public static void main(String[] args) {
        /*
         * Problem:
         * Given a list of strings, filter strings with length greater than 3
         * and convert them to uppercase using Java Streams.
         *
         * Input:
         * ["java", "is", "fun", "streams", "api"]
         *
         * Output:
         * ["JAVA", "STREAMS"]
         */

        List<String> list = List.of("java", "is", "fun", "streams", "api");

        List<String> ans = list.stream()
                .filter(word -> word.length() > 3)
                .toList();

        System.out.println(ans);

    }
}

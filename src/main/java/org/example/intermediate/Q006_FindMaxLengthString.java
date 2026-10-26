package org.example.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q006_FindMaxLengthString {
    /*
     * Problem:
     * Given a list of strings, find the string with maximum length using Java Streams.
     *
     * Input:
     * ["java", "springboot", "api", "microservices"]
     *
     * Output:
     * "microservices"
     */

    public static void main(String[] args) {
        List<String> list = List.of("java", "springboot", "api", "microservices");
        Optional<String> result = list.stream()
                .max(Comparator.comparingInt(String::length));

        System.out.println(result.get());
    }
}

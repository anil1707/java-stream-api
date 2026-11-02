package org.example.intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q011_HandleDuplicateKeys {
    /*
     * Problem:
     * Given a list of strings, convert it into a Map where:
     * key = string
     * value = length of string
     *
     * If duplicate keys are present, keep the first occurrence.
     *
     * Input:
     * ["java", "api", "java", "stream"]
     *
     * Output:
     * {java=4, api=3, stream=6}
     */
    public static void main(String[] args) {

        List<String> list = List.of("java", "api", "java", "stream");

        Map<String, Integer> map = list.stream()
                        .collect(Collectors.toMap(
                                str -> str,
                                str -> str.length(),
                                (oldValue, newValue) -> oldValue
                        ));

        map.forEach((key, value) -> {
            System.out.println(key + "-----> " + value);

        });
    }
}

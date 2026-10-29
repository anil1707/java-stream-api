package org.example.intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q008_GroupByFirstCharacter {
    /*
     * Problem:
     * Given a list of strings, group them by their first character using Java Streams.
     *
     * Input:
     * ["apple", "banana", "avocado", "blueberry", "cherry"]
     *
     * Output:
     * {
     *   a=[apple, avocado],
     *   b=[banana, blueberry],
     *   c=[cherry]
     * }
     */

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "avocado", "blueberry", "cherry");
        Map<Character, List<String>> ans = list.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));


        for(Map.Entry<Character, List<String>> entry : ans.entrySet()){
            System.out.println(entry.getKey() + " ---> " + entry.getValue());
//            System.out.println();
        }
    }
}

package org.example.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q012_SortMapByValue {
    /*
     * Problem:
     * Given a map of String -> Integer, sort the map by values in ascending order.
     *
     * Input:
     * {a=3, b=1, c=2}
     *
     * Output:
     * {b=1, c=2, a=3}
     */

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("a", 3, "b", 1, "c", 2);
        List<Map.Entry<String, Integer>> map1 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                        .toList();

        System.out.println(map1);



    }
}

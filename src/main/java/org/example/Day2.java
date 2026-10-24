package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) {
//        List<Integer> numbers = List.of(
//                10, 20, 30, 20, 40, 50, 10, 60, 30, 70
//        );

//        problem1: Find duplicate numbers
//        Map<Integer, Long> map = numbers.stream()
//                .collect(Collectors.groupingBy(
//                        number -> number,
//                        Collectors.counting()
//                ));
//
//        map.entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(entry -> entry.getKey())
//                .forEach(val -> System.out.println(val));

//       Problem2: Find the first non-repeating character
//        String str = "swiss";
//        Map<Integer, Long> mapCount = str.chars()
//                .boxed()
//                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
//
//        Character ans = str.chars()
//                .filter(entry -> mapCount.get(entry) == 1)
//                .mapToObj(entry -> (char) entry)
//                .findFirst()
//                .orElse(null);
//
//        System.out.println("Ans: " + ans);


//        Problem3: Find the first repeating character
//        String str = "abcd";
//        Map<Integer, Long> mapCount = str.chars()
//                .boxed()
//                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
//
//        Character ans = str.chars()
//                .filter(ch -> mapCount.get(ch) > 1)
//                .mapToObj(ch -> (char) ch)
//                .findFirst()
//                .orElse(null);
//
//        System.out.println("Ans: " + ans);

//        Problem4: find the second-highest frequency element
//        List<Integer> numbers = List.of(10, 20, 10, 30, 20, 10, 40, 30, 30, 30);

//        Map<Integer, Long> mapCount = numbers.stream()
//                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));
//
//        int ans = numbers.stream()
//                .distinct()
//                .sorted(Comparator.comparingDouble(number -> mapCount.get(number)).reversed())
//                .skip(1)
//                .findFirst()
//                .orElse(-1);
//
//        System.out.println("Ans: " + ans);

//        Problem 5: Find the longest word in each sentence
//        List<String> words = List.of(
//                "Java is powerful",
//                "Spring Boot simplifies development",
//                "Streams are interesting"
//        );
//
//        List<String> ans1 = words.stream()
//                .map(sen -> Arrays.stream(sen.split(" "))
//                        .max(Comparator.comparingInt(word -> word.length())).orElse(null)
//                )
//                .toList();
//
//        for(String temp : ans1){
//            System.out.println(temp);
//        }

//        Problem 6 — Find the most frequent word in a sentence
//        String sentence = "java spring java streams spring streams java streams streams streams";
//        Map<String, Long> map = Arrays.stream(sentence.split(" "))
//                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
//
//        Map.Entry<String, Long> ans = map.entrySet().stream()
//                        .max(Comparator.comparingLong(entry -> entry.getValue()))
//                                .orElse(null);
//
//        if(ans != null){
//            System.out.println(ans.getKey());
//        }


//        Problem 7 — Find the top 3 most frequent words
        List<String> sentences = List.of(
                "java spring boot",
                "java streams spring",
                "java boot streams",
                "spring java streams",
                "boot java spring"
        );

        Map<String, Long> map = sentences.stream()
                .flatMap(sen -> Arrays.stream(sen.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        map.entrySet().stream()
                .sorted(
                        Comparator.comparingLong(
                                (Map.Entry<String, Long> entry) -> entry.getValue()).reversed()
                                .thenComparing(entry -> entry.getKey()))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


    }
}

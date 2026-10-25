package org.example;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        if(s.isEmpty()) return 0;
        int ans = 1;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                if(j <= map.get(s.charAt(i))){
                    ans = Math.max(ans, (i - j));
                    j = map.get(s.charAt(i))+1;
                }
                map.put(s.charAt(i), i);

            } else {
                map.put(s.charAt(i), i);
            }
            i++;
        }

        return Math.max(ans, i - j);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
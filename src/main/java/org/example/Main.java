package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        String result = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println(result);
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }
}
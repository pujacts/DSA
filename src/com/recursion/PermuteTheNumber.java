package com.recursion;

import java.util.*;

public class PermuteTheNumber {

    public static List<List<Character>> permute(int num){

        List<List<Character>> result = new ArrayList<>();
        permute(String.valueOf(num), 0, result, new ArrayList<>());
        return result;
    }

    private static void permute(String num, int index, List<List<Character>> result, List<Character> curr){
        result.add(new ArrayList<>(curr));
        for(int i = index; i < num.length(); i++){
            char ch = num.charAt(i);
            curr.add(ch);
            permute(num, i + 1, result, curr);
            curr.remove(curr.size() - 1);
        }

    }

    public static void main(String[] args) {
        int num = 1234;

        List<List<Character>> result = permute(num);
        System.out.println(result);
    }
}

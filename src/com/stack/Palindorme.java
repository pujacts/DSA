package com.stack;

import java.util.Stack;

public class Palindorme {
    public static void main(String[] args){
       String str = "ABABA";
       System.out.println(isPalindorme(str));
}

    private static boolean isPalindorme(String str) {
        int len = str.length();
        int i;
        Stack<Character> stk = new Stack<>();
        for(i=0; i<len/2; i++){
            stk.push(str.charAt(i));
        }
        if(len%2!=0){
            i++;
        }
        while(i<len){
            char reverseEle = stk.pop();
            if(str.charAt(i) == reverseEle){
                return true;
            }
            i++;
        }
        return false;
    }
    }

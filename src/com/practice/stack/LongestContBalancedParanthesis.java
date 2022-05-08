package com.practice.stack;

import java.util.Stack;

public class LongestContBalancedParanthesis {

    public static void main(String[] args){
        //String expn = "{()}[]";
        String expn = ")()";

        System.out.print("result after isParanthesis blanced : " + longstContBalParen(expn));
    }

    private static int longstContBalParen(String expn) {

        int size = expn.length();
        int length = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for(int i =0; i<size; i++){
            if( expn.charAt(i) == '('){
                stk.push(i);
            } else {
                stk.pop();
                if(stk.size() != 0){
                    length = Math.max(length , i - stk.peek());
                } else {
                    stk.push(i);
                }
            }
        }
        return length;
    }
}

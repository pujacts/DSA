package com.practice.stack;

import java.util.Stack;

public class MaxDepthParanthesis {

    public static void main(String[] args){
        String expn = "((((A)))((((BBB()))))()()()())";
        System.out.println("maximum depth size parantheis : " + maxDepth(expn));
    }

    private static int maxDepth(String expn) {
        int depth = 0;
        int maxDepth = 0;
        Stack<Character> stk = new Stack<>();

        for (Character ch : expn.toCharArray()){
            if(ch == '('){
                stk.push(ch);
                depth = depth+1 ;
            } else if(ch == ')'){
                depth = depth - 1;
            }

            if(maxDepth< depth){
                maxDepth = depth;
            }
        }

        return  maxDepth;
    }

}

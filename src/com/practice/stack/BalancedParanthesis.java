package com.practice.stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args){
        //String expn = "{()}[]";
        String expn = "{()}{[]";
        boolean value = isBalanced(expn);
        System.out.print("result after isParanthesis blanced : " + value);
    }

    private static boolean isBalanced(String expn) {
        Stack<Character> stk = new Stack<>();

        for(Character ch : expn.toCharArray()){
            switch (ch){
                case '{' :
                case '(' :
                case '[' :
                    stk.push(ch);
                    break;
                case '}' :
                    if(stk.pop() != '{'){
                        return false;
                    }
                    break;
                case ')' :
                    if(stk.pop() != '('){
                        return false;
                    }
                    break;
                case ']' :
                    if(stk.pop() != '['){
                        return false;
                    }
                    break;
            }
        }
        return stk.isEmpty();
    }
}

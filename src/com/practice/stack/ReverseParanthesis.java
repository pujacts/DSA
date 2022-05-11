package com.practice.stack;

import java.util.Stack;

public class ReverseParanthesis {

    public static void main(String[] args){
        String expn = ")(())(((";
        System.out.print("result after isParanthesis blanced : " + reverseParanthesis(expn));
    }

    private static int reverseParanthesis(String expn) {
        int openCount = 0;
        int closeCount = 0;
        Stack<Character> stk = new Stack<>();


        if(expn.length() % 2 ==1){
            System.out.println("invalid odd length : "+ expn.length());
            return -1;
        }

        for(int i =0 ; i< expn.length(); i++){
            char ch = expn.charAt(i) ;
            if(ch  == '('){
                stk.push(ch);
            } else {
                if(stk.size()!=0 && stk.peek() == '('){
                    stk.pop();
                } else {
                    stk.push(ch);
                }
            }
        }
        while(stk.size()!=0){
            if(stk.pop() == '('){
                openCount = openCount+1;
            } else {
                closeCount = closeCount + 1;
            }
        }

        int reverse = (int)Math.ceil(openCount/2.0) + (int)Math.ceil(closeCount/2.0);
        return reverse ;
    }
}

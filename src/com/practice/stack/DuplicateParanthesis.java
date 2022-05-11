package com.practice.stack;

import java.util.Stack;

public class DuplicateParanthesis {

    public static void main(String[] args){
        String expn = "((a+b)+c)";
        System.out.print("Duplicate found : " + duplicate(expn));
    }

    private static boolean duplicate(String expn) {
        Stack<Character> stk = new Stack<>();
        char ch;
        int count = 0;

        for(int i=0 ; i< expn.length(); i++){

            count = 0;
            ch = expn.charAt(i);
            if(ch == ')'){
                while(stk.size()!=0 && stk.peek()!='('){
                    stk.pop();
                    count = count+1;
                }
                if(count<=1){
                    return true;
                }
            } else {
                stk.push(ch);
            }
        }
        return false;
    }

}

package com.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args){
        String expn = "10+((3))*5/(16-4)";

        String value = infixToPostfix(expn, expn.length());
        System.out.println("PostFix expression :" + value);
        System.out.println("PostFix evalutaion :" + postfixEval(value));
    }

    private static String infixToPostfix(String expn, int size) {

        String output = "";
        char out;
        Stack<Character> stk = new Stack<>();
        for(int i =0 ; i< size; i++){
            char ch = expn.charAt(i);
            if(ch<='9' && ch>='0'){
                output = output + ch;
            } else {
                switch (ch){
                    case '+' :
                    case  '-':
                    case '*':
                    case '/':
                    case '%':
                    case '^':
                        while(!stk.isEmpty() && precedence(ch)<= precedence(stk.peek())){
                            out = stk.pop();
                            output = output + " " + out;
                        }
                        stk.push(ch);
                        output = output + " ";
                        break;
                    case '(':
                        stk.push(ch);
                        break;
                    case ')':
                        while(!stk.isEmpty() &&  (out = stk.pop())!= '('){
                            output = output + " " + out + " ";
                        }
                        break;
                }
            }
        }
        while(!stk.isEmpty()){
            out = stk.pop();
            output = output + " " + out + " ";
        }
        return output;

    }

    public static int precedence(char ch){
        if(ch == '('){
            return 0;
        }
        if(ch == '+' || ch == '-'){
            return 1;
        }
        if(ch == '*' || ch == '/' || ch== '%'){
            return 2;
        }
        if(ch == '^')
            return 3;

        return 4;
    }

    public static int postfixEval(String output){
        int num1;
        int num2;
        int result = 0;
        Stack<Integer> stk = new Stack<>();
        Scanner tokens = new Scanner(output);
        while(tokens.hasNext()){
            if(tokens.hasNextInt()){
                stk.push(tokens.nextInt());
            } else {
                num1 = stk.pop();
                num2 = stk.pop();
                char ch = tokens.next().charAt(0);
                if(ch == '+'){
                    result = num1 + num2;
                    stk.push(result);
                } else if(ch == '-'){
                    result = num1 - num2;
                    stk.push(result);
                } else if(ch == '*'){
                    result = num1 * num2;
                    stk.push(result);
                } else if(ch == '/'){
                    result = num1 / num2;
                    stk.push(result);
                } else if(ch == '^'){
                    result = num1 ^ num2;
                    stk.push(result);
                }
            }

        }
        tokens.close();
      return stk.pop();
    }
}

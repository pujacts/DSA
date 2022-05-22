package com.stack;

import java.util.Stack;

public class FindCelebrity {
    public static void main(String[] args){
        int[][] M = { {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0} };
        int size = M.length;
        int celebrity = findCelebrity(M,size);


        //using brute force
        int celebrity1 = findCelebrityUsingBruteForce(M, size);
        if(celebrity1==-1) {
            System.out.println("No Celebrity");
        } else System.out.println(celebrity1);
    }

    private static int findCelebrityUsingBruteForce(int[][] m, int size) {
        int celeb = 0;
        int result = -1;
        for(int i = 0; i<size; i++){
            celeb = i;
            for(int j=0; j<size ; j++){
                if(i!=j && m[i][j]==1){
                break;
            }
                if(i!=j && m[j][i]==0)
                    break;
             if(j==size-1){
                 result = celeb;
             }
            }
        }
        return result;
    }


    private static int findCelebrity(int[][] m, int size) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<size; i++){
            stk.push(i);
        }
        int first = stk.pop();
        while(stk.size()!=0){
            int second = stk.pop();
            if(isKnown(m, first, second)){
                first = second;
            }
        }
        for(int i=0; i<size; i++){
            if(i!=first && isKnown(m, i, first) == false){
                return -1;
            }
            if(i!=first && isKnown(m, first, i)){
                return -1;
            }
        }
        return first;
    }

    private static boolean isKnown(int[][] m, int first, int second) {
        if(m[first][second] == 1){
            return true;
        }
        return false;
    }
}

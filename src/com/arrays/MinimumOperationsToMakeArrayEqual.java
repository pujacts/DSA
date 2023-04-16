package com.arrays;


import java.util.Arrays;

public class MinimumOperationsToMakeArrayEqual {
        public static int minOperationsToMakeElementsEqual(int N, int[] A) {
            int max_val = Arrays.stream(A).max().getAsInt();
            int operations = 0;

            while (!areAllElementsEqual(A)) {
                for (int i = 0; i < N; i++) {
                    if (A[i] > max_val / 2) {
                        A[i] = (int) Math.floor(A[i] / 2);
                        operations++;
                    }
                    else if(A[i] == max_val / 2){
                        continue;
                    }
                }
                max_val = Arrays.stream(A).max().getAsInt();
            }

            return operations;
        }

    public static boolean areAllElementsEqual(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[0]) {
                return false;
            }
        }
        return true;
    }

        public static void main(String[] args) {
            int N = 2;
            int[] A = {4,12};
            int minOperations = minOperationsToMakeElementsEqual(N, A);
            System.out.println("Minimum number of operations to make all elements equal: " + minOperations);
        }
    }

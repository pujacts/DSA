package com.arrays;

import java.util.ArrayList;

public class factorial {

    public static void main(String[] args) {
        int N = 10;
        int[] arr = {1,1,0,2};
        long ans = maxProduct(arr, arr.length);
        System.out.println(ans);
        ArrayList<Integer>  list = factorial(N);
    }

    private static long maxProduct(int[] arr, int n) {
        long maxProduct = arr[0];
        if(n==1){
            return arr[0];
        }

        for(int i = 0; i<n; i++){
            long temp = arr[i];
            for(int j = i+1; j<n; j++){
                maxProduct = Math.max(temp, maxProduct);
                temp = temp* arr[j];

            }
            maxProduct = Math.max(temp, maxProduct);
        }
        return maxProduct;
    }

    static ArrayList<Integer> factorial(int N){

        //code here
        ArrayList <Integer> arr= new ArrayList <>();

        arr.add(1);

        for(int i=1; i<=N; i++){
            int carry=0;

            for(int j=arr.size()-1; j>=0; j--){
                int val=arr.get(j)*i+carry;
                arr.set(j,val%10);
                carry=val/10;
            }

            while(carry!=0){
                arr.add(0,carry%10);
                carry=carry/10;
            }
        }

        return arr;
    }
}

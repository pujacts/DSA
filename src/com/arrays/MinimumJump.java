package com.arrays;

public class MinimumJump {

    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2, 6, 7};
        int n = arr.length;
        System.out.println(
                "Minimum number of jumps to reach end is "
                        + minJumps(arr, 0, n - 1));

        int jump = minJumpsDynamic(arr, n);

        System.out.println(jump);
    }

    private static int minJumpsDynamic(int[] arr, int n) {

       int[] jumps = new int[n];
       jumps[0] = 0;

       for(int i =1; i< n; i++){
           jumps[i] = Integer.MAX_VALUE;
           for(int j=0; j< i;j++){
               if((i<=j+arr[j]) &&
                   jumps[j] != Integer.MAX_VALUE) {
                       jumps[i]
                               = Math.min(jumps[i], jumps[j] + 1);
                       break;
               }
           }
       }

        return jumps[n-1];
    }

    private static int minJumps(int[] arr, int l, int h) {

        if(l==h){
            return 0;
        }

        if(arr[l]==0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;

        for(int i = l+1; i<=h && i<= l+arr[l]; i++){
            int jumps = minJumps(arr, i, h)+1;
            if(min > jumps){
                min = jumps;
            }
        }
        return min;
    }
}

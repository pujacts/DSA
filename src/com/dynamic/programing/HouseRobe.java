package com.dynamic.programing;

import java.util.Arrays;

public class HouseRobe {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        HouseRobe robe = new HouseRobe();
        int ans = robe.rob(arr);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        int n= nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int ans1 = rob(Arrays.copyOfRange(nums,0,n-1));
        int ans2 = rob(Arrays.copyOfRange(nums,1,n));
        return Math.max(ans1, ans2);
    }

    public int rob(int[] num, int idx){
        if(idx==0) return num[idx];

        if(idx<0) return 0;

        int pick = num[idx] + rob(num, idx-2);
        int notPick = rob(num, idx-1);

        return Math.max(pick,notPick);
    }
}

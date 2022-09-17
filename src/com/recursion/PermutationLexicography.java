package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationLexicography {

    public static void main(String[] args) {
        String str = "ABB";

        List<String> ans = find_permutation(str);
        System.out.println(ans);
    }

    private static List<String> find_permutation(String S) {

        String appnd = "";
        List<String> ans = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return ans;
        }
        boolean[] freq = new boolean[S.length()];
        char[] ch = S.toCharArray();
        Arrays.sort(ch);
        find_permutation(ch, ans, freq, appnd);
        return ans;
    }

    private static void find_permutation(char[] ch, List<String> ans, boolean[] freq, String appnd) {
        if(appnd.length() == ch.length){
            if (!ans.contains(appnd)) {

                ans.add(appnd);
            }
            return;
        }

        for(int i =0; i<ch.length; i++){

            if(!freq[i]){
                appnd = appnd + ch[i] ;
                freq[i]= true;
                find_permutation(ch, ans, freq, appnd);
                appnd = appnd.substring(0, appnd.length()-1);
                freq[i] = false;
            }
        }

    }

}

package com.substring;

public class BruteForceSearch {

    public int search(String text, String pattern){
        int lengthOftext = text.length();
        int lengthOfPattern = pattern.length();
        int i=0 , j=0;
        for( i =0 ; i<=(lengthOftext-lengthOfPattern); i++){
            for( j=0; j<lengthOfPattern; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j==lengthOfPattern) return i;
        }


         return -1;

    }

    public static void main(String[] args) {
        BruteForceSearch bruteForceSearch = new BruteForceSearch();
        System.out.println(bruteForceSearch.search("this is test!", "test"));
    }
}

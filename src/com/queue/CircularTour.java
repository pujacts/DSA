package com.queue;

public class CircularTour {

    public static void main(String[] args) {
        int[][] tour = {{4, 6},
                {6, 5},
                {7, 3},
                {4,5}};
        System.out.println("Circular tour : " + tour(tour, 3));
    }

    private static int tour(int[][] tour, int n) {
        int balancePetrol = 0;
        int requiredPetrol = 0;
        int startPoint = 0;
        int i =0;
       while(i<n){
          balancePetrol+= (tour[i][0] - tour[i][1]) ;
          if(balancePetrol<0){
              startPoint = i+1;
              requiredPetrol +=balancePetrol;
              balancePetrol = 0;
          }
          i++;
       }

       if(requiredPetrol+balancePetrol>0) return startPoint;
       return -1;
    }


}
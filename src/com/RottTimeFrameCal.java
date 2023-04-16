package com;

public class RottTimeFrameCal {

    public static int rotTime(int [][] mat){
        int totalTime= 0 ;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == -1){
                    totalTime += rotTime(mat, i, j);
                }
            }
        }
        return totalTime > 0 ? totalTime : -1;
    }

    public static int rotTime(int [][] mat, int row , int col){
        int count = 0;
        if(row < 0 || col < 0 || row >= mat.length || col >= mat[row].length || mat[row][col] == 0){
            return 0;
        }
        mat[row][col] = -1;
        count = 1;
        count += rotTime(mat, row, col + 1);
        count += rotTime(mat, row + 1, col);
        count += rotTime(mat, row, col - 1);
        count += rotTime(mat, row + 1, col);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("puja");
      /* int mat[][] =
        {
            {-1,  1, 0, -1, 1},
            { 1,  0, 1, -1, 1},
            { 1,  0, 0, -1, 1}
        };*/

        int mat[][] =
                {
                        {-1,  1,   1, 1, 1},
                        { 1,  0,  -1, 1, 1},
                        { 1,  0,   1, 1, 1}
                };

        rotTime(mat);

    }
}

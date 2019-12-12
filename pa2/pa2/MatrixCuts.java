package pa2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.io.*;
import java.util.*;

//@author Merin Mundt
public class MatrixCuts {


    public static ArrayList<Tuple> widthCut(int [][] M){
        //To store the result after cutting.
        ArrayList<Tuple> result = new ArrayList<Tuple>();

        //If M is invalid, return our empty result
        if(M == null || M.length == 0) return result;

        int rows = M.length;
        int cols = M[0].length;

        int [][] DP = new int [rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0){
                    DP[i][j] = M[i][j]; // We can only get to the first row from the first row.
                }else if(j == 0){
                    DP[i][j] = DP[i - 1][j] + M[i][j]; //We can only get to the first column from the elements abouve
                }else if(j + 1 < cols ){
                    DP[i][j] = M[i][j] +  min(DP[i-1][j], DP[i-1][j+1], DP[i-1][j-1]);  //We can get to the mid column from 3 places.
                }else{
                    DP[i][j] = M[i][j] + Math.min(DP[i-1][j], DP[i-1][j-1]); //We can only get to the last column from two places
                }
            }
        }

        //By the time we are done, the min cost will be the cell with the smallest value in the last row.

        int i = rows - 1;
        int min_col = 0;
        int min_cost = DP[i][min_col]; //Start with the min first element in the last row.

        //We will find the min element in the last row.
        for(int a = 0; a < cols; a++){
            if(DP[i][a] < min_cost){
                min_cost = DP[i][a];
                min_col = a;
            }
        }

        //Add the first (last pos)
        result.add(new Tuple(i, min_col));


        int tempIndex = 0;
        int row_min;

        //Perculate back and try to figure out how we get back up. We have 3 choices
        for(int b = rows - 2; b >= 0; b--){
            row_min = Integer.MAX_VALUE;

            if(min_col + 1 < cols){
                row_min = DP[b][min_col + 1];
                tempIndex = min_col + 1;
            }

            if(min_col - 1 >= 0){
                if(row_min > DP[b][min_col - 1]){
                    row_min = DP[b][min_col - 1];
                    tempIndex = min_col - 1;
                }
            }

            if(row_min > DP[b][min_col]){
                row_min = DP[b][min_col];
                tempIndex = min_col;
            }

            result.add(new Tuple(b, tempIndex));
            min_col = tempIndex;
        }

        result.add(new Tuple(min_cost, -1));
        Collections.reverse(result);
        return result;

    }


    public static ArrayList<Tuple> stitchCut(int [][] M){

        ArrayList<Tuple> result = new ArrayList<Tuple>();

        //If M is invalid, return our empty result
        if(M == null || M.length == 0) return result;

        int rows = M.length;
        int cols = M[0].length;

        int [][] DP = new int [rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0){
                    DP[i][j] = M[i][j]; //First Row
                }else if(j == 0){
                    DP[i][j] = DP[i - 1][j] + M[i][j]; //We can only get to the first column from cells above
                }else{
                    DP[i][j] = M[i][j] +  min(DP[i-1][j-1], DP[i-1][j], DP[i][j-1]); //We can get to the cells in the middle from min of the 3 spots.
                }
            }
        }

        //By the time we are done, the min cost will be the cell with the smallest value in the last row.

        int i = rows - 1;
        int min_col = 0;
        int min_cost = DP[i][0]; //Start with the min first element in the last row.

        //We will find the min element in the last row.
        for(int a = 0; a < cols; a++){
            if(DP[i][a] < min_cost){
                min_cost = DP[i][a];
                min_col = a;
            }
        }

        //Add the first one.
        result.add(new Tuple(i, min_col));

        //Now we perculate back up to find the min cost path
        while(i > 0){
            if(min_col > 0 && DP[i][min_col - 1] < DP[i - 1][min_col] && DP[i][min_col - 1] < DP[i - 1][min_col - 1]){
                result.add(new Tuple(i, min_col - 1));
                min_col--;
            }else if(min_col == 0 || i > 0 && DP[i - 1][min_col] < DP[i][min_col - 1] && DP[i - 1][min_col] < DP[i - 1][min_col - 1]){
                result.add(new Tuple(i - 1, min_col));
                i--;
            }else if(i > 0 && min_col > 0){
                result.add(new Tuple(i - 1, min_col - 1));
                i--;
                min_col--;
            }
        }
        //Add the cost tuple to the ArrayList.
        result.add(new Tuple(min_cost, -1));
        Collections.reverse(result);
        return result;

    }

    private static int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
    public static void main(String[] args) {
       int [][] M = {{5,7,9,4,5},{2,3,1,1,2},{2,0,49,46,8},{3,1,1,1,1},{50,51,25,26,1}};

       ArrayList<Tuple> s = widthCut(M);
       ArrayList<Tuple> e = stitchCut(M);
        System.out.println("WidthCut");
        for(Tuple t : s){
           System.out.println(t.toString());
       }

       System.out.println("---------------");
        System.out.println("Stich Cut");

        for(Tuple ta : e){
            System.out.println(ta.toString());
        }

    }

}
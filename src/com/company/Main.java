package com.company;

import java.util.Scanner;

public class Main {

    private static void print(int m, int n, int[][] arr){
        for(int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " \t");
            }
            System.out.println("\n");

        }
        System.out.println("--------------------------------");

    }


    private static void copy(int m, int n, int[][] arr, int[][] arr2){

        for(int i=0; i<m; i++){
            for (int j=0; j<n;j++){
                arr2[i][j] = arr[i][j];
            }
        }
    }






    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int count = -1;
        int m = scan.nextInt();
        int n = scan.nextInt();
        int r = scan.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){    //Initialize array with values
            for(int j=0; j<n; j++){
                arr[i][j]=++count;
            }
        }

        int min = Math.min(m, n);       //Find the minimum of the two
        if(min%2==0) {                  //Program runs only if minimum of the two numbers is even.

            int[][] arr2 = new int[m][n];       //Clone arr in arr2
            copy(m, n, arr, arr2);


            print(m, n, arr);       //Prints the initial Matrix

            for (int z = 0; z < r; z++) {       //Loop for number of rotations.
                int b = 0;
                while (b < min/2) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            if(m==n) {
                                if (i == b && j == b)        //Top Left corner
                                    arr[i + 1][j] = arr2[i][j];
                                if (i == m - 1 - b && j == b)      //Bottom Left Corner
                                    arr[i][j + 1] = arr2[i][j];
                                if (i == m - 1 - b && j == n - 1 - b)    //Bottom Right Corner
                                    arr[i - 1][j] = arr2[i][j];
                                if (i == b && j == n - 1 - b)      //Top Right Corner
                                    arr[i][j - 1] = arr2[i][j];
                                if (b < min / 2 - 1) {
                                    if (i > b && i < m - 1 - b && j == b)      //Extreme left line of matrix
                                        arr[i + 1][j] = arr2[i][j];
                                    if (j > b && j < n - 1 - b && i == m - 1 - b)    //Bottom line
                                        arr[i][j + 1] = arr2[i][j];
                                    if (i > b && i < m - 1 - b && j == n - 1 - b)    //Right line
                                        arr[i - 1][j] = arr2[i][j];
                                    if (j > b && j < n - 1 - b && i == b)      //Top line
                                        arr[i][j - 1] = arr2[i][j];
                                }
                            }
                            else if(m>n){
                                if (i == b && j == b)        //Top Left corner
                                    arr[i + 1][j] = arr2[i][j];
                                if (i == m - 1 - b && j == b)      //Bottom Left Corner
                                    arr[i][j + 1] = arr2[i][j];
                                if (i == m - 1 - b && j == n - 1 - b)    //Bottom Right Corner
                                    arr[i - 1][j] = arr2[i][j];
                                if (i == b && j == n - 1 - b)      //Top Right Corner
                                    arr[i][j - 1] = arr2[i][j];
                                if (i > b && i < m - 1 - b && j == b)      //Extreme left line of matrix
                                    arr[i + 1][j] = arr2[i][j];
                                if (i > b && i < m - 1 - b && j == n - 1 - b) {
                                    arr[i - 1][j] = arr2[i][j];     //Right line

                                }
                                if (b < min / 2 - 1) {
                                    if (j >b && j < n - 1 - b && i == m - 1 - b)    //Bottom line
                                        arr[i][j + 1] = arr2[i][j];
                                    if (j > b && j < n - 1 - b && i == b)      //Top line
                                        arr[i][j - 1] = arr2[i][j];
                                }
                            }
                            else {
                                if (i == b && j == b)        //Top Left corner
                                    arr[i + 1][j] = arr2[i][j];
                                if (i == m - 1 - b && j == b)      //Bottom Left Corner
                                    arr[i][j + 1] = arr2[i][j];
                                if (i == m - 1 - b && j == n - 1 - b)    //Bottom Right Corner
                                    arr[i - 1][j] = arr2[i][j];
                                if (i == b && j == n - 1 - b)      //Top Right Corner
                                    arr[i][j - 1] = arr2[i][j];

                                if (j > b && j < n - 1 - b && i == m - 1 - b)    //Bottom line
                                    arr[i][j + 1] = arr2[i][j];
                                if (j > b && j < n - 1 - b && i == b)      //Top line
                                    arr[i][j - 1] = arr2[i][j];

                                if (b < min / 2 - 1) {
                                    if (i > b && i < m - 1 - b && j == b)      //Extreme left line of matrix
                                        arr[i + 1][j] = arr2[i][j];
                                    if (i > b && i < m - 1 - b && j == n - 1 - b)
                                        arr[i - 1][j] = arr2[i][j];
                                }
                            }
                        }
                    }
                    b = b + 1;
                    copy(m, n, arr, arr2);
                }

            }
            print(m, n, arr);
        }
    }
}

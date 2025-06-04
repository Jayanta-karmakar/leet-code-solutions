package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JAYANTA KARMAKAR
 * @date 30-05-2025
 **/

@Slf4j
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        System.out.println("Input of Matrix1 : ");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Output for matrix1 : ");
        printMatrix(matrix1);

        System.out.println("Input of Matrix2 : ");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("Output for matrix2:");
        printMatrix(matrix2);
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

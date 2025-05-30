package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import java.util.Arrays;

/**
 * @author JAYANTA KARMAKAR
 * @date 30-05-2025
 **/

public class SetMatrixZeroes {

    static void printMatrix(int[][] matrix) {
        for (int[] fullMatrix : matrix) {
            System.out.println(Arrays.toString(fullMatrix));
        }
    }

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

//        setZeroes(matrix1);
        System.out.println("Output for matrix1:");
        printMatrix(matrix1);

//        setZeroes(matrix2);
        System.out.println("Output for matrix2:");
        printMatrix(matrix2);
    }
}

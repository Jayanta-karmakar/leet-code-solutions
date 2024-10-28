package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 28/10/24, Monday
 **/

@Slf4j
public class CountSquares {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        // Iterate through the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell is a '1' and not on the first row or column
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    // Update the cell with the size of the largest square ending here
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                }
                // Add the current cell's value to the count
                count += matrix[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix ={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        log.info("Output : {}", countSquares(matrix));
    }
}

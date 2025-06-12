package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JAYANTA KARMAKAR
 * @date 04-06-2025
 **/

@Slf4j
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> dummyRow = new ArrayList<>();
            dummyRow.add(0);
            dummyRow.addAll(res.get(res.size() - 1));
            dummyRow.add(0);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < dummyRow.size() - 1; j++) {
                row.add(dummyRow.get(j) + dummyRow.get(j + 1));
            }

            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);

        for (int i = 0; i < result.size(); i++) {
            for(int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

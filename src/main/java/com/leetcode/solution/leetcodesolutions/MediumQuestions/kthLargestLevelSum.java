package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 23/10/24, Wednesday
 **/

@Slf4j
@RequiredArgsConstructor
public class kthLargestLevelSum {

    public static long kLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        // Queue to perform BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // List to store the sums of each level
        List<Long> levelSums = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the sum of the current level to the list
            levelSums.add(levelSum);
        }

        // Sort the level sums in descending order
        levelSums.sort(Collections.reverseOrder());

        // Check if we have at least k levels
        if (k > levelSums.size()) {
            return -1;
        }

        // Return the kth largest level sum
        return levelSums.get(k - 1);
    }

    public static void main(String[] args) {
        // Construct the tree based on the given input
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        // Create an instance of the Solution class and call the method
        int k = 2;
        long result = kLargestLevelSum(root, k);

        // Print the result
        log.info("The {}th largest level sum is: {}", k, result);
    }

    @Data
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Default constructor
        public TreeNode() {}

        // Constructor that initializes the node's value
        public TreeNode(int val) {
            this.val = val;
        }

        // Constructor that initializes the node's value, left child, and right child
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

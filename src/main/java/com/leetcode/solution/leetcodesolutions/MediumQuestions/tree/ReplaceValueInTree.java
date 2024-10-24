package com.leetcode.solution.leetcodesolutions.MediumQuestions.tree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 23/10/24, Wednesday
 **/

@Slf4j
public class ReplaceValueInTree {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        // Use a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Set the root node's value to 0 as it has no cousins
        root.val = 0;

        // Start the level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            // Array to store current level nodes
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Calculate the sum of all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                // Add left and right child nodes to the queue and calculate the sum
                if (node.left != null) {
                    queue.offer(node.left);
                    levelSum += node.left.val;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelSum += node.right.val;
                }
            }

            // Replace each node's value with the sum of its cousins
            for (TreeNode node : currentLevelNodes) {
                int siblingSum = 0;

                // Calculate sibling's value
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                // Update the values of the children nodes with the cousin sum
                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                }
            }
        }

        return root;
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

package com.leetcode.solution.leetcodesolutions.MediumQuestions.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 26/10/24, Saturday
 **/

@Slf4j
public class TreeQueries {

    public static void main(String[] args) {
        // Step 1: Build the tree
        TreeNode root = buildTree(new Integer[]{1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7});

        // Step 2: Create an instance of the Solution class
        TreeQueries solution = new TreeQueries();

        // Step 3: Define the queries
        int[] queries = {4};

        // Step 4: Call the method and print the results
        int[] result = solution.treeQueries(root, queries);
        System.out.println("Output: " + Arrays.toString(result)); // Expected: [2]
    }

    // Helper method to build a tree from an array representation
    private static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    private Map<Integer, Integer> heightMap = new HashMap<>();
    private Map<Integer, List<Integer>> depthNodes = new HashMap<>();
    private Map<Integer, Integer> depthOfNode = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        // Find the height of each node and also keep track of the nodes at each depth
        dfsHeight(root, 0);

        // Prepare the maximum heights for each depth level excluding the subtree of a specific node
        Map<Integer, Integer[]> maxHeightAtDepth = new HashMap<>();
        for (int depth : depthNodes.keySet()) {
            List<Integer> nodes = depthNodes.get(depth);
            int firstMax = -1, secondMax = -1;
            for (int node : nodes) {
                int height = heightMap.get(node);
                if (height > firstMax) {
                    secondMax = firstMax;
                    firstMax = height;
                } else if (height > secondMax) {
                    secondMax = height;
                }
            }
            maxHeightAtDepth.put(depth, new Integer[]{firstMax, secondMax});
        }

        // Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int depth = depthOfNode.get(queryNode);
            int nodeHeight = heightMap.get(queryNode);

            // Check if the node removed was at depth 1 (direct child of the root)
            if (depth == 1) {
                result[i] = calculateHeightAfterRemoval(root, queryNode);
            } else {
                // Get the two largest heights at this depth
                Integer[] maxHeights = maxHeightAtDepth.get(depth);
                int newHeight = (maxHeights[0] == nodeHeight) ?
                        (maxHeights[1] + depth) : (maxHeights[0] + depth);
                result[i] = newHeight;
            }
        }

        return result;
    }

    // Calculate height after removing a direct child subtree
    private int calculateHeightAfterRemoval(TreeNode root, int removedValue) {
        // Helper function to calculate tree height after removing a direct child subtree
        int leftHeight = (root.left != null && root.left.val != removedValue) ? heightMap.get(root.left.val) + 1 : 0;
        int rightHeight = (root.right != null && root.right.val != removedValue) ? heightMap.get(root.right.val) + 1 : 0;
        return Math.max(leftHeight, rightHeight);
    }

    // A DFS function to compute the height of each node and store nodes at each depth
    private int dfsHeight(TreeNode node, int depth) {
        if (node == null) return -1;

        int leftHeight = dfsHeight(node.left, depth + 1);
        int rightHeight = dfsHeight(node.right, depth + 1);
        int height = Math.max(leftHeight, rightHeight) + 1;

        heightMap.put(node.val, height);
        depthNodes.computeIfAbsent(depth, k -> new ArrayList<>()).add(node.val);
        depthOfNode.put(node.val, depth);

        return height;
    }
}

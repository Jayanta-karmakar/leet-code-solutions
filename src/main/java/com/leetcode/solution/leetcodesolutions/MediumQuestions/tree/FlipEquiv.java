package com.leetcode.solution.leetcodesolutions.MediumQuestions.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 24/10/24, Thursday
 **/

@Slf4j
public class FlipEquiv {
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If both nodes are null, they are flip equivalent
        if (root1 == null && root2 == null) return true;

        // If one node is null or their values are not equal, not flip equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        // Check if children are flip equivalent without flipping or with flipping
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    public static void main(String[] args) {
        // Create the first tree: [1, 2, 3, 4, 5, 6, null, null, null, 7, 8]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        // Create the second tree: [1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        boolean result = flipEquiv(root1, root2);
        log.info("Are the two trees flip equivalent? {}", result);
    }
}

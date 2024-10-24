package com.leetcode.solution.leetcodesolutions.MediumQuestions.tree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 24/10/24, Thursday
 **/

@Data
@Setter
@Getter
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

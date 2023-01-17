package com.jaweee.tree;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 20:38
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

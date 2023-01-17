package com.jaweee.tree;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 20:33
 * @github: https://github.com/jaweee
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  这个类主要是用来写二叉树的遍历
 */
public class Traverse {

    /**
     *  层序遍历，将二叉树的每层按顺序输出
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int levelNum = 1;
        while (!deque.isEmpty()) {
            TreeNode pop = deque.removeFirst();
            List<Integer> levelList = new ArrayList<>();
            int t = 0;
            for (int i = 0; i < levelNum; i++) {
                if (pop.left != null) {
                    deque.addLast(pop.left);
                    t++;
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                    t++;
                }
                levelList.add(pop.val);
            }
            ret.add(levelList);
        }
        return ret;
    }

    /**
     *  先序遍历，利用递归
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     *  中序遍历，利用递归
     */
    public void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.left);
        System.out.println(root.val);
        middleOrder(root.right);
    }

    /**
     * 后序遍历， 利用递归
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

}

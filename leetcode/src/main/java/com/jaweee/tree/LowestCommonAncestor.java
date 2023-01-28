package com.jaweee.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author: me
 * @title: LowestCommonAncestor
 * @description:
 * @date: 2022/8/22 17:21
 */
public class LowestCommonAncestor {

    private TreeNode ans;

    /**
     * 1）基本的递归先序遍历算法 -> 遍历才能找到最深公共父节点
     * 2）保证公共父节点是最深的 -> 最深：先序遍历在递归出栈的时候，是由下往上的
     *                           公共：多情况的总和
     *                                           x为p和q之父（lson && rson），
     *                                           x为其中一个之父（ ((x == p || x == q )||(lson && rson)) ）
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){return false;}
        boolean l = dfs(root, p, q);
        boolean r = dfs(root, p, q);
        if ((l && r) || ((root.val == p.val) || root.val == q.val) || (l || r)){
            ans = root;
        }
        return l || r || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        this.dfs(root, p, q);
        return this.ans;
    }

}
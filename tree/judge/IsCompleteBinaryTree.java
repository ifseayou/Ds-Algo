package com.isea.dw.tree.judge;

import java.util.LinkedList;

/**
 * 判断二叉树是否是一个完全平衡二叉树
 * 如何判断呢？
 * 二叉树的层序遍历，来到某个节点，如果该节点
 * <p>
 * ①有右孩子没有左孩子，一定不是完全平衡二叉树
 * ②有左孩子没有右孩子或者左右孩子都没有，那么从该节点以后的节点都必须是叶子节点
 */
public class IsCompleteBinaryTree {
    private static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isCompleteBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode left = null;
        TreeNode right = null;
        boolean leaf = false; // 叶节点的阶段

        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;

            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {  // 有右没左；开启叶节点之后，后面不是叶节点
                return false;
            }

            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            }

            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);

        System.out.println(isCompleteBinaryTree(head));  // true
    }
}

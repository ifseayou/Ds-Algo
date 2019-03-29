package com.isea.dw.tree.judge;

import java.util.LinkedList;

/**
 * 判断一棵树数是否是二分搜索树
 * <p>
 * 中序遍历是否是顺序的
 */
public class IsBinarySearchTree {

    static LinkedList<Integer> queue = new LinkedList<Integer>();

    private static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void inOrder(TreeNode head) {
        if (head != null) {
            return;
        }
        inOrder(head.left);
        queue.offer(head.data);
        inOrder(head.right);
    }

    public static boolean isBinarySearchTree(TreeNode head) {
        inOrder(head);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            if (min > value) {
                return false;
            }
            min = value;
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(1);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);

        System.out.println(isBinarySearchTree(head)); // true
    }
}

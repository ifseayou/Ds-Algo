package com.isea.dw.tree.judge;

/**
 * 判断是否是平衡二叉树
 * 本质是一个树形DP的过程，判断左子树是否是一颗平衡二叉树，在判断右子树是否是一个平衡二叉树
 * 最后在判断整体是否是一颗平衡二叉树，判断的函数要返回相同的结构
 */
public class IsBalanceTree {
    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    private static class ReturnData {
        private boolean isB;
        private int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(TreeNode head) {
        return process(head).isB;
    }

    // 返回node节点为根节点的树否是平衡二叉树，如果是，返回当前的高度
    public static ReturnData process(TreeNode node) {
        if (node == null) {
            return new ReturnData(true, 0);
        }
        // 判断左树是否是一颗平衡二叉树
        ReturnData left = process(node.left);
        if (!left.isB) {
            return new ReturnData(false, 0); // h 此时已经不需要了，递归返回的全是false
        }
        // 判断右树是否是一颗平衡二叉树
        ReturnData right = process(node.right);
        if (!right.isB) {
            return new ReturnData(false, 0);
        }

        // 判断当前节点是否是一颗平衡二叉树
        if (Math.abs((left.h - right.h)) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(left.h, right.h) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isB(head)); // true
    }
}
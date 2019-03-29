package com.isea.dw.tree;

import java.util.LinkedList;

/**
 * 二叉树的序列化
 */
public class SerialBinaryTree {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    // 序列化  先序的方式序列化
    public static String serialBinaryTree(TreeNode head){
        StringBuilder res = new StringBuilder();
        if (head == null){
            return res.append("#_").toString();
        }

        res.append(head.val + "_");
        res.append(serialBinaryTree(head.left));
        res.append(serialBinaryTree(head.right));
        return res.toString();
    }
    // 反序列化 还是按照先序的方式反序列化
    public static TreeNode deSerialBinaryTree(String str){
        LinkedList<String> queue = new LinkedList<>();
        String[] nodes = str.split("_");
        for (String node : nodes) {
            queue.offer(node);
        }
        return deSerialBinaryTree(queue);

    }

    private static TreeNode deSerialBinaryTree(LinkedList<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = deSerialBinaryTree(queue);
        head.right = deSerialBinaryTree(queue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode head = null;
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);

        System.out.println(serialBinaryTree(head));
    }



}

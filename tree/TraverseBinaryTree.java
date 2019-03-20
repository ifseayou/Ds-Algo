package com.isea.dw.tree;

/**
 * 遍历二叉树，前序，中序，后序的递归写法
 */
public class TraverseBinaryTree {
    public  class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static void preOrder(Node node){
        System.out.print(node.data + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        inOrder(node.left);
        System.out.print(node.data + "->");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "->");
    }
}

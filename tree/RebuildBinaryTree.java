package com.isea.dw.tree;

/**
 * 重建二叉树输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class RebuildBinaryTree {
    public static class Node<T> {
        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node rebuild(int[] preOrder,int[] midOrder){
        if (preOrder == null || midOrder == null || preOrder.length < 2 || midOrder.length < 2){
            return null;
        }
       return rebuild(preOrder,0  ,preOrder.length - 1,midOrder,0,midOrder.length - 1);
    }

    private static Node rebuild(int[] preOrder, int preStart, int preEnd, int[] midOrder, int minStart, int minEnd) {
        if (preStart > preEnd || minStart > minEnd){
            return null;
        }

        Node<Integer> root = new Node<Integer>(preOrder[preStart]);
        for (int cur = minStart ; cur < minEnd ; cur ++){
            if (midOrder[cur] == preOrder[preStart]){
                root.left = rebuild(preOrder,preStart +1,preStart + cur - minStart,midOrder,minStart,cur - 1);
                root.right = rebuild(preOrder,preStart + cur - minStart + 1,preEnd ,midOrder,cur + 1,minEnd);
                break;
            }
        }
        return root;
    }

    /**
     *  preStart + cur - minStart
     *  preStart + cur - minStart + 1
     *  各有什么含义？
     */

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] minOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        rebuild(preOrder,minOrder);
    }
}

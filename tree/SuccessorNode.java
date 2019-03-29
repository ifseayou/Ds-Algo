package com.isea.dw.tree;

/**
 * 在一棵树中寻找某一个节点的后继节点
 *
 * 如何寻找一个节点的后继节点呢？
 * 如果当前节点有右子树，那么右子树最左边的节点即为当前节点的后继
 * 如果当前节点没有右子树，那么当前节点为其父亲节点的左子树的时候，父亲节点即为目标节点的后继
 */
public class SuccessorNode {
    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    // 求一个节点的后继节点
    public static TreeNode getSuccessorNode(TreeNode head){
        if (head == null){
            return null;
        }
        if (head.right != null){
            return getMostLeft(head.right);
        } else {
            TreeNode parent = head.parent;
            while( parent != null && parent.left == head){ // parent != null 主要最后一个元素，其后继为null。
                head = parent;
                parent = head.parent;
            }
            return parent;
        }
    }

    // 求以node为根节点的最左边的节点
    private static TreeNode getMostLeft(TreeNode node) {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.parent = null;
        head.left = new TreeNode(3);
        head.left.parent = head;
        head.left.left = new TreeNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new TreeNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new TreeNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new TreeNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new TreeNode(9);
        head.right.parent = head;
        head.right.left = new TreeNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new TreeNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new TreeNode(10);
        head.right.right.parent = head.right;

        TreeNode test = head.left.left;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.left.left.right;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.left;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.left.right;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.left.right.right;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.right.left.left;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.right.left;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.right;
        System.out.println(test.val + " next: " + getSuccessorNode(test).val);
        test = head.right.right; // 10's next is null
        System.out.println(test.val + " next: " + getSuccessorNode(test));
    }
}
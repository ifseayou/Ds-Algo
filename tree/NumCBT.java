package com.isea.dw.tree;

/**
 * 求一个完全二叉树的节点个数，时间复杂度要求小于O(N)
 * <p>
 * num = 2 ^ h - 1 ; h 是层数； num是完全满二叉树的节点个数。先遍历一下二叉树的左边界，得到二叉树的高度h；
 * 然后遍历当前节点的右子树的左边界，如果到达了最后一层，则当前节点的左子树是满的 ，就能够求出左子树的个数，
 * 对于右树，也是一个完全二叉树，递归去求左子树的个数。假如当前节点的右子树没有到达最后一层，右子树是满的，
 * 递归去求当前节点的左子树。这里当前节点的左子树和右子树是满的话，高度是不一样的。
 */
public class NumCBT {
    public static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int getCompleteBinaryTreeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    // node是当前节点，level表示当前节点在第几层，h是一个固定值，就是这颗树的深度 ；返回以node为头节点的这颗树的节点个数。
    private static int bs(TreeNode node, int level, int depth) {
        if (level == depth) { // 如果当前的节点的来到了最后一层，节点个数就是1
            return 1;
        }
        // 判断当前节点的右子树的深度有没有到达整个数的深度
        if (mostLeftLevel(node.right, level + 1) == depth) {
            return (1 << (depth - level)) + bs(node.right, level + 1, depth);
        } else {
            return (1 << (depth - level - 1)) + bs(node.left, level + 1, depth);
        }
    }

    // 返回在level层的head节点，最深到了第几层
    public static int mostLeftLevel(TreeNode head, int level) {
        while (head != null) {
            head = head.left;
            level++;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        System.out.println(getCompleteBinaryTreeNum(head));
    }
}

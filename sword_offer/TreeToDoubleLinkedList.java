package com.isea.dw.sword_offer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeToDoubleLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inorderToQueue(pRootOfTree,queue);

        if (queue.isEmpty()){
            return pRootOfTree;
        }

        // 弹出队首元素，做为链表的表头
        pRootOfTree = queue.poll();

        TreeNode pre = pRootOfTree;
        pre.left = null;
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.left = cur;
            cur.right = pre;
            pre = cur;
        }

        pre.right = null;
        return pRootOfTree;
    }

    // 将二叉树转化为队列
    private void inorderToQueue(TreeNode head, Queue<TreeNode> queue) {
       if (head == null){
           return;
       }
       inorderToQueue(head.left,queue);
       queue.offer(head);
       inorderToQueue(head.right,queue);
    }

}

package com.isea.dw.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 利用辅助队列实现
 */
public class PrintFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> data = new ArrayList<>();
        if (root == null){
            return data;
        }

        LinkedList<TreeNode> help = new LinkedList<>();

        help.add(root);
        while(!help.isEmpty()){
            TreeNode res = help.pop();
            data.add(res.val);
            if (res.left != null){
                help.add(res.left);
            }
            if (res.right != null){
                help.add(res.right);
            }
        }
        return data;
    }
}

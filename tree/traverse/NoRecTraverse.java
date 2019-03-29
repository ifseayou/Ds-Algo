package com.isea.dw.tree.traverse;

import java.util.Stack;

/**
 * 二叉树的非递归先序遍历
 */
public class NoRecTraverse {
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // 先序遍历=> 接助辅助栈实现
    public static void preOrder(Node head){
        System.out.println("Pre-Order-NoRec");
        Stack<Node> help = new Stack<>();
        if (head == null){
            return;
        }
        help.push(head);
        while(!help.isEmpty()){
             head = help.pop();
            System.out.println(head.data + " ");
            if (head.right != null){
                help.push(head.right);
            }
            if (head.left != null){
                help.push(head.left);
            }
        }
        System.out.println();
    }

    // 中序遍历,左根右，如果当前节点为null，从栈中取出一个元素打印，当前节点往右；如果当前节点不为null，当前节点入栈，当前节点向左
    public static void inOrder(Node head){
        System.out.println("In-Order-NoRec");
        if (head == null){
            return;
        }
        Stack<Node> help = new Stack<>();
        while(!help.isEmpty() || head != null){
            if (head != null){
                help.push(head);
                head = head.left;
            }else {
                head = help.pop();
                System.out.println(head.data + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    // 后续遍历，左右根 ： 先实现根右左，打印的时候不打印，而是放入到栈中
    public static void postOrder(Node head){
        System.out.println("Post-Order-NoRec");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                help.push(head);
                if (head.left != null){
                    stack.push(head.left);
                }
                if (head.right != null){
                    stack.push(head.right);
                }
            }
            while(!help.isEmpty()){
                System.out.print(help.pop().data + " ");
            }
        }
        System.out.println();
    }

    // 层序遍历：在PrintFromToToBottom中已经写了
}

package com.isea.dw.sword_offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindTargetInTree {
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(Node root,int target){
        if (root == null){
            return  res;
        }
        findPath(root,target);
        return res;
    }

    private void findPath(Node root, int target) {

        // 先将根节点加入到path中
        path.add(root.data);

        // 如果已经到了叶子节点，而且target == 路径只和（其实就是当前的root值），将path加入到结果集中
        if (root.data == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }

        // 如果左子树非空，递归遍历左子树
        if (root.left != null){
            findPath(root.left,target - root.data);
        }

        // 如果右子树非空，递归遍历右子树
        if (root.right != null){
            findPath(root.right,target - root.data);
        }

        // 无论当前路径是否加出了target，必须从去掉path的最后有一个（变换左右子树的目的），返回父节点，去查找下一条（右边）的路径，最终的path为null
        path.remove(path.size() - 1);
        return;
    }
}

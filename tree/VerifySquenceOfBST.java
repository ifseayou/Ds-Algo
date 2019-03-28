package com.isea.dw.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 如果序列的长度为0的话，认为不是二分搜索树
        if (sequence.length == 0){
            return false;
        }
        // 判断是x到y范围是否为二分搜索树
        return isBST(sequence,0,sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        // 如果end <= start 比如只有一个元素
        if (end <= start){
            return true;
        }
        // i 从start的位置开始，
        int i = start;

        // 验证所有左子树全部小于根
        for (; i < end; i++){
            if (sequence[i] > sequence[end]){
                break;
            }
        }
        // 验证是否所有的右子树都小于根
        for (int j = i;j < end;j ++){
            if (sequence[j] < sequence[end]){
                return false;
            }
        }
        // 判断左子树和右子树是否是二分搜索树
        return isBST(sequence,start,i - 1) && isBST(sequence,i, end - 1);
    }

}

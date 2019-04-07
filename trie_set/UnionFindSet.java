package com.isea.dw.trie_set;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集，并查集主要实现两个功能：
 * ①判断元素A和元素B是否是在同一个集合中
 * ②将元素A所在的集合和元素B所在的集合合并
 *
 * 并查集在初始的时候，必须要给定所有的值，并将所有节点的父都指向它自己，不能实现动态加入
 *
 * 优化问题：每一次在回溯的时候，都将当前节点直接挂到代表节点上
 */
public class UnionFindSet {
    public class Node{
        // 这里只是一个结构，你放置什么都可以
    }
    private HashMap<Node,Node> fatherMap; // 这里存放的是当前节点和当前节点的父节点
    private HashMap<Node,Integer> sizeMap; // 这里存放的是当前节点所在的集合一共有多少个节点，是一个值

    // 初始化
    public UnionFindSet(List<Node> nodes){
      makeSet(nodes);
    }

    private void makeSet(List<Node> nodes) {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node : nodes) {
            fatherMap.put(node,node);
            sizeMap.put(node,1);
        }
    }

    // 找到node节点的代表节点，优化过程（将当前节点直接挂在代表节点上面）放置在该方法中
    public Node findHead(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            father = fatherMap.get(father);
        }
        fatherMap.put(node,father);
        return father;
    }

    // 判断元素A和元素B是否属于同一个集合
    public boolean isSameSet(Node a,Node b){
        return findHead(a) == findHead(b);
    }

    // 将元素A所在的集合和元素B所在的集合合并
    public void union(Node a,Node b){
        if (a == null || b == null){
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);

        if (aHead != bHead){
            Integer aSetSize = sizeMap.get(a);
            Integer bSetSize = sizeMap.get(b);
            if (aSetSize > bSetSize){
                fatherMap.put(bHead,aHead);
                sizeMap.put(aHead,aSetSize + bSetSize);
            }else {
                fatherMap.put(aHead,bHead);
                sizeMap.put(bHead,aSetSize + bSetSize);
            }
        }
    }

}

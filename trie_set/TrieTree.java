package com.isea.dw.trie_set;

/**
 * 前缀树：
 * ①时间复杂度和并查集本身没有关系，只和样本字符串的长度有关
 * ②经典的前缀树的实现，一定不要将数据放在节点上，所以前缀树上来一定会有一个root节点
 * 实现的需求：
 * 前缀树中是否有以target为前缀的字符串 -->  path 有多少个字符路过当前字符
 * 前缀树中有多少个以target为前缀的字符串 --> end 有多少个字符串以当前字符结尾
 * 前缀树中是否有字符串target --> path
 */
public class TrieTree {
    public class TrieNode{
        private int path;
        private int end;
        private int[] nexts; // 这里限制了路的条数，所以设置为一个数组，还可以使用HashMap
        public TrieNode(){
            path = 0;
            end = 0;
            nexts = new int[26];
        }
    }
    private TrieNode root;
    public TrieTree(){
        root = new TrieNode();
    }


}

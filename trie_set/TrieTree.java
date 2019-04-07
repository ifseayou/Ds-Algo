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
        private TrieNode[] nexts; // 这里限制了路的条数，所以设置为一个数组，还可以使用HashMap
        public TrieNode(){
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }
    private TrieNode root;
    public TrieTree(){
        root = new TrieNode();
    }

    // 向字典树中插入字符串word
    public  void insert(String word){
        if (word == null){
            return;
        }
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path ++; // 来到一个字符之后，来到当前字符的个数加一
        }
        node.end ++; // 添加完一个字符串之后，以当前字符结尾的字符加一
    }

    // 判断字符串word在字典树中出现了几次
    public int search(String word){
        if (word == null){
            return 0;
        }
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 判断字典树中有多少个字符串以pre为前缀
    public int prefixNum(String pre){
        if (pre == null){
            return 0;
        }
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < pre.length(); i++) {
            index = pre.charAt(i) - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            System.out.println("-----TIA-----");
            node = node.nexts[index];
        }
        return node.path;
    }

    // 删除字典树中的word字符串
    public void delete(String word){
        if (search(word) != 0){
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if ( --node.nexts[index].path == 0){ // 到达节点-1如果等于0 后面的字符可以直接减去了，表示该字符串只是出现了一次
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end --;
        }
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.search("isea")); // 0
        trie.insert("isea");
        System.out.println(trie.search("isea")); // 1
        trie.delete("isea");
        System.out.println(trie.search("isea")); // 0
        trie.insert("isea");
        trie.insert("isea");
        trie.insert("isea");
        System.out.println(trie.search("isea")); // 3
        System.out.println(trie.prefixNum("isea")); // 3
    }

}

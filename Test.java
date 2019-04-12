package com.isea.dw;

import java.util.Stack;

public class Test<T> {

    public  class Node {
        private T t;
        private Node next;
        public Node(T t){
            this.t = t;
        }
    }
    public Node delete(Node dummyHead,int N){
        Stack<Node> ts = new Stack<>();
        Node cur = dummyHead.next;
        while(cur!= null){
            ts.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < N; i++) {
            ts.pop();
        }
        Node res = ts.pop();

        Node pre = dummyHead;
        while(pre.next != res){
            pre = pre.next;
        }

        cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        return dummyHead;
    }
}



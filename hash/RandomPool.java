package com.isea.dw.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * 设计一种结构：该结构中有三个功能，insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key): 将某个key删除；getRandom()等概论返回结构中的任何一个key，要求三个方法的时间复杂度是O(1)
 */
public class RandomPool<T>{
    private HashMap<T,Integer> map1;
    private HashMap<Integer,T> map2;
    private int size;

    public RandomPool(){
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        size = 0;
    }

    public void insert(T target){
        map1.put(target,size);
        map2.put(size,target);
        size ++;
    }

    public T getRandom(){
        if (map1.isEmpty()){
            return null;
        }
        int index = new Random().nextInt(size);
        return map2.get(index);
    }

    public void delete(T target){
        if (map1.containsKey(target)){

            int lastIndex = --size;
            map2.put(map1.get(target),map2.get(lastIndex));

            map1.remove(target);
            map2.remove(lastIndex);
        }
    }
}

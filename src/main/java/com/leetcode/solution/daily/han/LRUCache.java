package com.leetcode.solution.daily.han;

/**
 * @ProjectName
 * @ClassName
 * @ClassDescription TODO
 * @CreateBy
 * @CreateAt
 * @Version 1.0
 */

import java.util.HashMap;

/**LRU缓存 实现
        设计一种数据存储结构，容量 get（key） 有值则返回， 无则返回-1
        put（key，value），若缓存中没有，则写入，有值则更新值为本地put的，若超出
        容量，则删除最近为使用的key->value
        Example:
        *
        * LRUCache cache = new LRUCache( 2  capacity  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
*/
class LRUCache {
    // 采用哈希表 + 双向链表实现
    // 哈希表，在查找时时间复杂是O(1);
    // 双向链表 记录value值的最近使用情况，并且删除 和 写入操作时间复杂度是O(1)
    private HashMap<Integer,Node> map;
    private LinkedList cache;
    private int cap;

     public LRUCache(int cap){
         this.cap = cap;
         this.map = new HashMap<>();
         this.cache = new LinkedList();
}

    // get方法
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        int val = map.get(key).value;
        // 此时需要把key——val放到链表的头部，表示当前key刚刚使用了
        put(key,val);
        return val;
    }

    public void put(int key, int value){
        // 定义一个新节点
        Node x = new Node(key,value);
        // 判map中是否有此key，有则删除链表中此key对应的节点，将新的x插入到链表头部
        if(map.containsKey(key)){
            // 删除链表中结点元素
//            cache.remove(x);
            cache.remove(map.get(key));
            // 链表头部增加x
            cache.addFirst(x);
            // map 中更新key对应的value值
            map.put(key,x);
        } else{
            // 不存在，先判断链表元素个数是否超容量
            if (cache.size() == this.cap) {
                // 删除链表尾元素
                Node last = cache.removeLast();
                // map中删除对应此元素的key-value
                map.remove(last.key);
            }

            // 将x 添加到链表 头部
            cache.addFirst(x);
            // map 中存入此key-value
            map.put(key,x);
        }
    }

// 定义一个LinkedList 链表
class LinkedList{
    // 虚拟头、尾节点
    private Node head,tail;
    // 链表中元素个数
    private int size;

    public LinkedList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    // 链表头部添加元素
    public void addFirst(Node x){
        /*
         *头结点的next指向x，x的prev指向head,
         * x的next指向head之前next指向的元素p
         * p的prev指向x；
         *
         *        next
         *    head ->  p...tail
         *        <-
         *        prev
         *
         *        next   next
         *    head ->  x -> p...tail
         *        <-     <-
         *        prev    prev
         *
         */

        x.next = this.head.next;
        this.head.next.prev = x;

        // x的prev指向head
        x.prev = this.head;
        // head的next指向x
        this.head.next = x;

        this.size++;
    }

    // 删除链表的元素（元素x一定存在）
    public void remove(Node x){
        x.next.prev = x.prev;
        x.prev.next = x.next;
        this.size--;
    }

    // 删除链表的尾元素，并返回此值
    public Node removeLast() {
        // 判断是否为空链表
        if (this.tail.prev == this.head) {
            return null;
        }

        Node last = this.tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size(){
        return this.size;
    }
}


// 定义Node类
class Node {
    private int key,value;
    private Node next,prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        // returns 1
        System.out.println(cache.get(1));

        // evicts key 2
        cache.put(3,3);

        // returns -1 (not found)
        cache.get(2);

        System.out.println(cache.get(2));

        // evicts key 1
        cache.put(4,4);

        // returns -1 (not found)
        System.out.println(cache.get(1));

        // returns 3
        System.out.println(cache.get(3));

        System.out.println(cache.get(4));
    }
}
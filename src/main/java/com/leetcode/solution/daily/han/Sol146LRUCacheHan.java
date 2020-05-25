package com.leetcode.solution.daily.han;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @Description Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
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
        *
        *来源：力扣（LeetCode）
        *链接：https://leetcode-cn.com/problems/lru-cache
        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-25 22:16
 * @Param
 * @return
 */
public class Sol146LRUCacheHan {
    // 看到 key value 首先 想到 哈希表 存取元素，时间复杂度都是O(1),
    // 本题需要记录哈希表中元素使用的情况，以判断 容量不足时，删除对应的元素（最近未使用过的元素）--使用双向连表，来存储这个使用情况
        // 一个map 存储 key->Node(key,val)
        private HashMap<Integer,Node> map;

        // 一个双向链表
        private  DoubleList cache;

        // 容量 cap
        private int cap;

        Sol146LRUCacheHan(int cap) {
            this.cap = cap;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 利用put 把 此key放到头部
            int val = map.get(key).value;
            put(key,val);
            return val;
        }

        public void put(int key, int val) {
            // 定义一个新节点
            Node x = new Node(key,val);

            // 在链表中插入新节点

            // 如果map中有此key，删除链表中此key的 节点， 将新的节点x插入到头部
            if (map.containsKey(key)) {
                cache.delete(map.get(key));
                cache.addFirst(x);
                // 更新map中key->x
                map.put(key,x);
            } else {
                // 如果不存在，首先判断是否超容量
                if (cache.size() == cap) {
                    // 删除链表最后一个元素
                     Node last = cache.removeLast();
                    // 删除map中的key,此处cache中一定要返回删除的尾元素，为了获取map要删除的key

                    map.remove(last.key);
                }

                // 将x添加到链表头部
                cache.addFirst(x);
                // map中增加此key
                map.put(key,x);
            }
        }

    // 定义一个双向链表
    class DoubleList {
        // 头尾 虚节点
        private Node head, tail;
        // 链表元素个数
        private int size;

        // 无参构造方法
        public DoubleList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
        }

        // 在头部添加元素
        public void addFirst(Node x) {
            // 把头指针的next指向x， x的prve指向head
            x.next = this.head.next;
            x.prev = this.head;
            // x 的 头指针指向head
            this.head.next.prev = x;
            this.head.next = x;
            size++;
        }

        // 删除链表中的元素x （x一定存在）
        public void delete(Node x) {
            x.next.prev = x.prev;
            x.prev.next = x.next;
            size--;
        }

        // 删除链表中的尾元素 并返回此值
        public Node removeLast() {
            // 判断链表是否为空
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            delete(last);
            return last;
        }

        // 返回链表长度
        public int size() {
            return  size;
        }

    }

    class Node {
        public int key,value;
        public Node next,prev;
        public Node (int k, int v) {
            this.key = k;
            this.value = v;

        }
    }

    public static void main(String[] args) {
        Sol146LRUCacheHan cache = new Sol146LRUCacheHan(2);
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

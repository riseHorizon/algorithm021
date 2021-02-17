package com.horizon.act;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class CnLinkedCache {
        Integer key;
        Integer value;
        CnLinkedCache prev, next;
    }

    private int capacity;
    private int size;
    private CnLinkedCache head;
    private CnLinkedCache tail;
    private Map<Integer, CnLinkedCache> dict;

    public LRUCache(final int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dict = new HashMap<Integer, CnLinkedCache>();
        head = new CnLinkedCache();
        tail = new CnLinkedCache();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CnLinkedCache node = dict.get(key);
        if(node == null) {
            return -1;
        }
        updateToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        CnLinkedCache node = dict.get(key);
        if(node == null) {
            node = new CnLinkedCache();
            node.value = value;
            node.key = key;

            dict.put(key, node);
            addToHead(node);
            this.size++;
            if(this.size > this.capacity) {
                CnLinkedCache oldNode = this.tail.prev;
                removeNode(oldNode);
                dict.remove(oldNode.key);
                this.size--;
            }
        } else {
            node.value = value;
            updateToHead(node);
        }
    }

    private void removeNode(CnLinkedCache node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(CnLinkedCache node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    private void updateToHead(CnLinkedCache node) {
        if(node != this.head) {
            removeNode(node);
            addToHead(node);
        }
    }
}


package com.horizon.act;

public class Trie {
    boolean isEnd;
    Trie[] next;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        char[] wDict = word.toCharArray();
        Trie cur = this;
        for(int i = 0; i < wDict.length; i++) {
            int idx = wDict[i] - 'a';
            if(cur.next[idx] == null) {
                cur.next[idx] = new Trie();
            }
            cur = cur.next[idx];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        char[]  wDict = word.toCharArray();
        Trie cur = this;
        for(int i = 0; i < wDict.length; i++) {
            int idx = wDict[i] - 'a';
            cur = cur.next[idx];
            if(cur == null) {
                break;
            }
        }
        return cur != null && cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] pDict = prefix.toCharArray();
        Trie cur = this;
        for(int i = 0; i < pDict.length; i++) {
            int idx = pDict[i] - 'a';
            cur = cur.next[idx];
            if(cur == null) {
                break;
            }
        }
        return cur != null;
    }
}
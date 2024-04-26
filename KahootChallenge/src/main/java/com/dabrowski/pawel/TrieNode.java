package com.dabrowski.pawel;

public class TrieNode {
    //  Our tree will contain only English small letters
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

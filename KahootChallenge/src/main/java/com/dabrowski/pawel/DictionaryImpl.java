package com.dabrowski.pawel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DictionaryImpl implements Dictionary {
    private final TrieNode root;

    public DictionaryImpl() {
        root = new TrieNode();
    }

    public DictionaryImpl(List<String> words) {
        root = new TrieNode();
        for(String word : words) {
            this.addElement(word);
        }
    }

    @Override
    public void addElement(String newElement) {
        TrieNode current = root;
        for (int i = 0; i < newElement.length(); i++) {
            int index = newElement.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    @Override
    public void removeElement(String oldElement) {

    }

    @Override
    public void addListOfElements(List<String> newElements) {

    }

    @Override
    public List<String> getElement(String letters) {
        List<String> result = new ArrayList<>();
        TrieNode current = root;
        StringBuilder found = new StringBuilder();

        // We are checking all letters of the given word
        for (char c : letters.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return result; // No match found
            }
            found.append(c);
            current = current.children[index];
        }

        result.add(found.toString());

        return result;
    }

}

package com.dabrowski.pawel;

import java.io.IOException;
import java.util.ArrayList;
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
    public void addListOfElements(List<String> newElements) {
        for (String newElement : newElements) {
            addElement(newElement);
        }
    }

    @Override
    public List<String> getElement(String letters) throws IllegalArgumentException {

        if(letters.isEmpty()){
            throw new IllegalArgumentException("Cannot pass empty String");
        }

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

        // Perform DFS algorithm to collect all words starting with prefix
        dfs(current, found, result);

        return result;
    }

    private void dfs(TrieNode node, StringBuilder sb, List<String> result) {
        if (node == null) {
            return;
        }
        // We add the whole word to list when we reach last letter
        if (node.isEndOfWord) {
            result.add(sb.toString());
        }
        // For each letter in child table we are collecting words
        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            if (node.children[index] != null) {
                sb.append(c);
                dfs(node.children[index], sb, result);
            }
        }
    }

    public void fillDictionary() {
        List<String> elements = new ArrayList<>();
        elements.add("car");
        elements.add("carpet");
        elements.add("java");
        elements.add("javascript");
        elements.add("internet");
        this.addListOfElements(elements);
    }

}

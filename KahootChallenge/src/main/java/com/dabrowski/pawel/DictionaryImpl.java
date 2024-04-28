package com.dabrowski.pawel;

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

        if (newElement == null || newElement.isEmpty()) {
            throw new IllegalArgumentException("Element can't be null or empty");
        }

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

        if(newElements.isEmpty()) {
            throw new IllegalArgumentException("List of elements can't be empty");
        }

        for (String newElement : newElements) {
            addElement(newElement);
        }
    }

    // Method used to get list of words with passed prefix
    @Override
    public List<String> getElement(String letters) throws IllegalArgumentException {

        if(letters.isEmpty()){
            throw new IllegalArgumentException("Prefix can't be empty");
        }

        List<String> result = new ArrayList<>();
        TrieNode current = root;
        StringBuilder found = new StringBuilder();

        // We are checking all letters of the given prefix
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

    // DFS algorithm to find all words with passed prefix
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

    // Method created to fill dictionary with sample words
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

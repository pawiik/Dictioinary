package com.dabrowski.pawel;

import java.util.Collections;
import java.util.List;

public class DictionaryImpl implements Dictionary {

    public DictionaryImpl() {

    }

    public DictionaryImpl(List<String> words) {
        for(String word : words) {
            this.addElement(word);
        }
    }

    @Override
    public void addElement(String newElement) {

    }

    @Override
    public void removeElement(String oldElement) {

    }

    @Override
    public void addListOfElements(List<String> newElements) {

    }

    @Override
    public List<String> getElement(String letters) {

        return Collections.emptyList();
    }
}

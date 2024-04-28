package com.dabrowski.pawel;

import java.util.List;

public interface Dictionary {

    void addElement(String newElement);
    void addListOfElements(List<String> newElements);
    List<String> getElement(String letters) throws IllegalArgumentException;

}

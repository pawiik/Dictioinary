package com.dabrowski.pawel;

import java.util.List;

public interface Dictionary {

    void addElement(String newElement);
    void removeElement(String oldElement);
    void addListOfElements(List<String> newElements);
    void getElement(String letters);

}

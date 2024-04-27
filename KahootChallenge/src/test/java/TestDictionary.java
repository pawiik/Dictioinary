import com.dabrowski.pawel.Dictionary;
import com.dabrowski.pawel.DictionaryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDictionary {

    static Dictionary dictionary;

    @BeforeAll
    static void setupTest(){
        List<String> elements = new ArrayList<>();
        elements.add("car");
        elements.add("carpet");
        elements.add("java");
        elements.add("javascript");
        elements.add("internet");
        dictionary = new DictionaryImpl(elements);
    }

    @Test
    void cLetterTest() {
        List<String> elements = dictionary.getElement("c");

        assertTrue(elements.contains("car"));
        assertTrue(elements.contains("carpet"));
    }

    @Test
    void carTest() {
        List<String> elements = dictionary.getElement("car");

        assertTrue(elements.contains("car"));
        assertTrue(elements.contains("carpet"));
    }

    @Test
    void carpTest() {
        List<String> elements = dictionary.getElement("carp");

        assertTrue(elements.contains("carpet"));
    }

    @Test
    void javTest() {
        List<String> elements = dictionary.getElement("jav");

        assertTrue(elements.contains("java"));
        assertTrue(elements.contains("javascript"));
    }

    @Test
    void queryNonExistentTest() {
        List<String> elements = dictionary.getElement("foo");

        assertTrue(elements.isEmpty());
    }
}

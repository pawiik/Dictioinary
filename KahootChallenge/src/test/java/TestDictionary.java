import com.dabrowski.pawel.Dictionary;
import com.dabrowski.pawel.DictionaryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


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
    void queryTest(){
        List<String> elements = new ArrayList<>();

        elements = dictionary.getElement("c");
        assert elements.contains("car");
        assert elements.contains("carpet");

        elements = dictionary.getElement("car");
        assert elements.contains("car");
        assert elements.contains("carpet");

        elements = dictionary.getElement("carp");
        assert elements.contains("carp");

        elements = dictionary.getElement("jav");
        assert elements.contains("java");
        assert elements.contains("javascript");

        elements = dictionary.getElement("intern");
        assert elements.contains("internet");

        elements = dictionary.getElement("foo");
        assert elements.contains("foo");
    }
}

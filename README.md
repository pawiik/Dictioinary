# Dictionary Implementation using Trie Data Structure

This Java program provides an implementation of a dictionary using a Trie data structure. It allows for adding words to the dictionary and retrieving words based on a given prefix.

## Usage

To use this dictionary implementation, follow these steps:

1. **Instantiate the Dictionary**: 
   You can create a new instance of the `DictionaryImpl` class, either empty or with a list of initial words.

   ```java
   Dictionary dictionary = new DictionaryImpl();
   // or
   List<String> initialWords = Arrays.asList("word1", "word2", "word3");
   Dictionary dictionary = new DictionaryImpl(initialWords);
    ```
    
2.  **Adding Elements**:
    You can add single elements or a list of elements to the dictionary using the addElement and addListOfElements     methods respectively.

    ```java
    dictionary.addElement("newWord");
    // or
    List<String> newWords = Arrays.asList("newWord1", "newWord2", "newWord3");
    dictionary.addListOfElements(newWords);
    ```
    
3.  **Retrieving Elements**:
    You can retrieve a list of words that match a given prefix using the getElement method.
    
    ```java
    List<String> matchedWords = dictionary.getElement("prefix");
    ```
    
4.  **Filling the Dictionary**:
    If you want to prepopulate the dictionary with some default words, you can use the fillDictionary method.
    
    ```java
    dictionary.fillDictionary();
    ```

## Example

Here's a simple example demonstrating the usage of this dictionary:
    
```java
DictionaryImpl dictionary = new DictionaryImpl();
dictionary.addElement("apple");
dictionary.addElement("application");
dictionary.addElement("banana");
    
List<String> matchedWords = dictionary.getElement("app");
System.out.println("Words starting with 'app': " + matchedWords);
```
    
Output: Words starting with 'app': [apple, application]
    
## Dependencies
    
Required dependencies 

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.9.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```



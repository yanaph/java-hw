package ua.fan.hw16;

import java.util.*;

public class Dictionary {
    final private LinkedHashMap<String, Integer> dictionary;

    public Dictionary(String str) {
        dictionary = new LinkedHashMap<>();
        createDictionary(str);
    }

    private void createDictionary(String str) {
        str = str.toLowerCase()
                .replaceAll("\\p{Punct}", "");
        String[] words = str.split(" ");
        Integer count;
        for (String word : words) {
            count = dictionary.get(word);
            if (count == null) {
                count = 0;
            }
            dictionary.put(word, ++count);
        }
    }

    void printSortedDictionary(){
        dictionary.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.print(entry.getKey() + " - " + entry.getValue() + "\n"));
    }
}
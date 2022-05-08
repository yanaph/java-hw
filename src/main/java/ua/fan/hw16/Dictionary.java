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
        int count = 0;
        for (String w : words) {
            for (String w2 : words) {
                if (w.equals(w2)) {
                    count++;
                }
            }
            dictionary.put(w, count);
            count = 0;
        }
    }

    void printSortedDictionary(){
        dictionary.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.print(entry.getKey() + " - " + entry.getValue() + "\n"));
    }
}
package com.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public Map<String, Integer> count(String string) {
        string = string.toLowerCase();
        string = string.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
        String[] splitString = string.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer> ();

        for(String word:splitString) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                int count = map.get(word);
                map.put(word, count + 1);
            }
        }
        return map;
    }

}

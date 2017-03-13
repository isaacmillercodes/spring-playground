package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WordCounter {

    @Bean
    public Map<String, Integer> count(String string) {
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

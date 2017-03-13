package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/words")
public class WordController {
    WordCounter wordcount;

    public WordController(WordCounter wordcount) {
       
    }

    @PostMapping("/count")
    public Map<String, Integer> wordCount(@RequestBody String string) {
        return wordcount.count(string);
    }
}

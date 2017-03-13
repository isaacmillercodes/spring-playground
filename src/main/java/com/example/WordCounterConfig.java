package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfig {
    @Bean
    public WordCounter wordCounter() {
        return new WordCounter();
    }
}

package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordCountTests {

    @MockBean
    WordCounterConfig config;

    @MockBean
    WordCounter wordCounter;

    @Autowired
    WordController controller;

    @Before
    public void setup() {
        when(config.wordCounter()).thenReturn(new WordCounter());
    }

    @Test
    public void wordCounterUnitTest() {
        WordCounter wordcounter = new WordCounter();
        HashMap testMap = new HashMap<String, Integer>();
        testMap.put("hey", 1);
        testMap.put("hi", 1);
        testMap.put("ho", 1);
        testMap.put("there", 3  );

        assertEquals("Should return map of word count", testMap, wordcounter.count("Hey there Hi there Ho there"));
    }

    @Test
    public void wordControllerAutowireTest() {
        controller.wordcount = new WordCounter();
        HashMap testMap = new HashMap<String, Integer>();
        testMap.put("space", 1);
        testMap.put("jam", 2);
        testMap.put("grape", 1);
        assertThat(controller.wordcount.count("Space jam, grape jam"), equalTo(testMap));
    }

    @Test
    public void wordControllerMockTest() {
        HashMap testMap = new HashMap<String, Integer>();
        testMap.put("run", 3);
        testMap.put("the", 3);
        testMap.put("jewels", 2);
        testMap.put("fast", 2);
        assertThat(config.wordCounter().count("Run the jewels fast, run the run the jewels fast"), equalTo(testMap));
    }


}

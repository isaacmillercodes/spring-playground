package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuerystringController.class)

public class QuerystringControllerTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void testBookTitle() throws Exception {
        this.mvc.perform(get("/books?title=Trout Fishing in America"))
                .andExpect(status().isOk())
                .andExpect(content().string("The title is: Trout Fishing in America"));
    }

    @Test
    public void testMovieHashMap() throws Exception {
        this.mvc.perform(get("/movies?title=I Heart Huckabees&year=2004"))
                .andExpect(status().isOk())
                .andExpect(content().string("{title=I Heart Huckabees, year=2004}"));
    }

    @Test
    public void testComicCustomObject() throws Exception {
        this.mvc.perform(get("/comics?title=Y the Last Man&author=Brian K. Vaughan"))
                .andExpect(status().isOk())
                .andExpect(content().string("Y the Last Man by Brian K. Vaughan"));
    }


}

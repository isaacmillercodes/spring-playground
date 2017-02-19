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
@WebMvcTest(PathVariableController.class)
public class PathVariableControllerTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void testArticleEndpoint() throws Exception {
        int articleId = 7;

        this.mvc.perform(get(String.format("/articles/%d", articleId)))
                .andExpect(status().isOk())
                .andExpect(content().string("Article id is 7"));
    }

    @Test
    public void testBloggerEndpoint() throws Exception {

        this.mvc.perform(get(String.format("/blogger/2/follower/5")))
                .andExpect(status().isOk())
                .andExpect(content().string("{bloggerId=2, followerId=5}"));
    }

    @Test
    public void testGameEndpoint() throws Exception {

        this.mvc.perform(get(String.format("/game/12/studio/28")))
                .andExpect(status().isOk())
                .andExpect(content().string("Game Id is 12; Studio Id is 28"));
    }


}

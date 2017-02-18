package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateEndpointsController.class)
public class CreateEndpointsControllerTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void testCreateEndpointsGet() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/createEndpoints");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Successful GET to /createEndpoints"));
    }

    @Test
    public void testCreateEndpointsPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/createEndpoints");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Successful POST to /createEndpoints"));
    }
}

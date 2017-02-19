package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void testCreatePerson() throws Exception {
        MockHttpServletRequestBuilder request = post("/people")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "Finn")
                .param("lastName", "Balor");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("firstName=Finn&lastName=Balor"));
    }

    @Test
    public void testCreateHero() throws Exception {
        MockHttpServletRequestBuilder request = post("/heroes")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Junkrat")
                .param("ultimate", "RIPtire");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{name=Junkrat, ultimate=RIPtire}"));
    }

    @Test
    public void testCreateWrestler() throws Exception {
        MockHttpServletRequestBuilder request = post("/wrestlers")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Stone Cold Steve Austin")
                .param("finishingMove", "Stone Cold Stunner");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("New wrestler named Stone Cold Steve Austin created with a finishing move called Stone Cold Stunner"));
    }




}

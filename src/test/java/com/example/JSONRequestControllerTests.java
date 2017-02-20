package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONRequestController.class)
public class JSONRequestControllerTests {
    @Autowired
    MockMvc mvc;

    private Gson gson = new GsonBuilder().create();

    @Test
    public void testStringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/wrestlers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Mankind\", \"finishingMove\": \"Mandible Claw\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Mandible Claw"));
    }

    static class WrestlerParams {
        final String name;
        final String finishingMove;

        WrestlerParams(String name, String finishingMove) {
            this.name = name;
            this.finishingMove = finishingMove;
        }
    }

    @Test
    public void testSerializedWrestler() throws Exception {
        WrestlerParams params = new WrestlerParams("Cactus Jack", "Underhook DDT");

        MockHttpServletRequestBuilder request = post ("/wrestlers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(params));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Underhook DDT"));
    }

    @Test
    public void testRawDonutData() throws Exception {
        String json = getJSON("/donuts.json");

        MockHttpServletRequestBuilder request = post("/donuts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Glazed"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}

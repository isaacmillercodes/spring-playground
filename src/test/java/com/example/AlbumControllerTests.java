package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    AlbumRepository repository;

    @Test
    public void testPost() throws Exception {
        MockHttpServletRequestBuilder request = post("/albums")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Awaken My Love\", \"bandName\": \"Childish Gambino\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Awaken My Love")))
                .andExpect(jsonPath("$.bandName", equalTo("Childish Gambino")));

        verify(this.repository).save(any(Album.class));
    }

    @Test
    public void testList() throws Exception {
        Long id = new Random().nextLong();
        Album album = new Album();
        album.setName("Run the Jewels 3");
        album.setBandName("Run the Jewels");
        album.setId(id);

        when(this.repository.findAll()).thenReturn(Collections.singletonList(album));

        MockHttpServletRequestBuilder request = get("/albums")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(id)))
                .andExpect(jsonPath("$[0].name", equalTo("Run the Jewels 3")))
                .andExpect(jsonPath("$[0].bandName", equalTo("Run the Jewels")));
    }
}


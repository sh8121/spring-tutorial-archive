package com.sboo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception {
        mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("/events/form"))
                .andExpect(model().attributeExists("event"));
    }

    @Test
    public void getEvent() throws Exception {
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isEmpty())
                .andExpect(jsonPath("name").isEmpty())
                .andExpect(jsonPath("limit").isEmpty());
    }

    @Test
    public void postEvent() throws Exception {
        mockMvc.perform(post("/events/name/sboo")
                        .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("sboo"))
                .andExpect(jsonPath("limit").value(-10));
    }
}
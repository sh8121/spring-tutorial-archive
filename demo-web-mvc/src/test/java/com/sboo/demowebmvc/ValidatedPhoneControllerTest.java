package com.sboo.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidatedPhoneControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loadFormPage() throws Exception {
        mockMvc.perform(get("/validatedPhone"))
                .andExpect(view().name("phoneHome"));
    }

    @Test
    public void submitForm() throws Exception {
        mockMvc.perform(post("/validatedPhone")
                        .accept(MediaType.TEXT_HTML_VALUE)
                        .param("phone", "111"))
                .andExpect(model().attributeHasFieldErrorCode("validatedPhone", "phone", "ContactNumberConstraint"))
                .andExpect(view().name("phoneHome"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

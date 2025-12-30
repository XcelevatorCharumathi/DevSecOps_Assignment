package com.example.sample_java_assignment_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpringbootSampleAppController.class)
class SpringbootSampleAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login_shouldFailForPostRequest() throws Exception {
        mockMvc.perform(post("/login"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void login_shouldReturnInvalidUser_whenNameMissing() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid user"));
    }

    @Test
    void login_shouldReturnLoginMessage_whenNameProvided() throws Exception {
        mockMvc.perform(get("/login").param("name", "Charu"))
                .andExpect(status().isOk())
                .andExpect(content().string("Please input your credentials for login..."));
    }

    @Test
    void register_shouldReturnRegisterMessage() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string("Please follow registration process..."));

    }
}

package com.example.sample_java_assignment_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SpringbootSampleAppIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void login_endpoint_shouldWork_integrationTest() throws Exception {
        mockMvc.perform(get("/login").param("name", "Charu"))
                .andExpect(status().isOk())
                .andExpect(content().string("Please input your credentials for login..."));
    }
}


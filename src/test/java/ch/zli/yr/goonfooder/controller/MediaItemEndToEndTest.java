package ch.zli.yr.goonfooder.controller;

import ch.zli.yr.goonfooder.NoSecurityConfig;
import ch.zli.yr.goonfooder.GoonFooderApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        classes = {GoonFooderApplication.class, NoSecurityConfig.class},
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@AutoConfigureMockMvc
public class MediaItemEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void endToEnd_createAndRetrieveItem() throws Exception {
        // Create
        mockMvc.perform(post("/media-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                      "title": "E2E Title",
                      "description": "E2E Description"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // Retrieve
        mockMvc.perform(get("/media-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}

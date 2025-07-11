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
        // ⬇️ das hier schließt SecurityConfig im Test aus
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@AutoConfigureMockMvc
public class MediaItemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenValidMediaItem_whenPost_thenItemIsPersisted() throws Exception {
        mockMvc.perform(post("/media-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                      "title": "Integration Test Title",
                      "description": "Integration Test Description"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("Integration Test Title"));
    }

    @Test
    void givenMediaItems_whenGet_thenReturnAll() throws Exception {
        mockMvc.perform(get("/media-items"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}

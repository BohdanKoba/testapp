package ua.com.integrity.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.integrity.Application;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class ApplicationRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnArrayOfAllWords() throws Exception {
        String request = "{\"words\":[\"fish\",\"horse\",\"egg\",\"goose\",\"eagle\"]}";

        mvc.perform(post("/game/check-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words", hasSize(5)))
                .andExpect(jsonPath("$.words").value(hasItems("fish", "horse", "egg", "goose", "eagle")));
    }

    @Test
    void shouldReturnListOfWordsUntilMistakeDetected() throws Exception {
        String request = "{\"words\":[\"fish\",\"horse\",\"snake\",\"goose\",\"eagle\"]}";

        mvc.perform(post("/game/check-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words", hasSize(2)))
                .andExpect(jsonPath("$.words").value(hasItems("fish", "horse")));
    }

    @Test
    void shouldReturnListOfWordsUntilEmptyValueDetected() throws Exception {
        String request = "{\"words\":[\"fish\",\"horse\",\"\",\"goose\",\"eagle\"]}";

        mvc.perform(post("/game/check-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words", hasSize(2)))
                .andExpect(jsonPath("$.words").value(hasItems("fish", "horse")));
    }

    @Test
    void shouldReturnEmptyArray() throws Exception {
        String request = "{\"words\":[\"\",\"horse\",\"\",\"goose\",\"eagle\"]}";

        mvc.perform(post("/game/check-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words", hasSize(0)));
    }
}

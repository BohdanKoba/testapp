package ua.com.integrity.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.integrity.service.impl.GameServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GameServiceImpTest {
    @Autowired
    private GameServiceImpl service;

    @Test
    void shouldReturnListOfAllWords() {
        List<String> words = Arrays.asList("fish", "horse", "egg", "goose", "eagle");

        List<String> expected = Arrays.asList("fish", "horse", "egg", "goose", "eagle");
        List<String> actual = service.checkWords(words).getWords();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnListOfWordsUntilMistakeDetected() {
        List<String> words = Arrays.asList("fish", "horse", "snake", "goose", "eagle");

        List<String> expected = Arrays.asList("fish", "horse");
        List<String> actual = service.checkWords(words).getWords();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnListOfWordsUntilEmptyValueDetected() {
        List<String> words = Arrays.asList("fish", "horse", "", "goose", "eagle");

        List<String> expected = Arrays.asList("fish", "horse");
        List<String> actual = service.checkWords(words).getWords();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyList() {
        List<String> words = Arrays.asList("", "horse", "", "goose", "eagle");

        List<String> expected = Collections.emptyList();
        List<String> actual = service.checkWords(words).getWords();
        assertEquals(expected, actual);
    }
}

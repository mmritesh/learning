package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void getWords() {
        final String input = "i am very very happy";
        Set<String> words = app.getWords(input);
        assertEquals(4, words.size());
    }
}
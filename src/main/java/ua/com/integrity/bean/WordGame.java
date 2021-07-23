package ua.com.integrity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Represents WordGame entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordGame {
    /**
     * List of words used during the game.
     */
    private List<String> words;
}

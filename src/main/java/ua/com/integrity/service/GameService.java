package ua.com.integrity.service;

import ua.com.integrity.bean.WordGame;

import java.util.List;

/**
 * WordGame service class.
 */
public interface GameService {
    /**
     * Checks the correctness of the WordGame results.
     * Returns WordGame object with words that were used in the game right.
     *
     * @param wordList list of words to check
     * @return WordGame object with words that were used in the game right
     */
    WordGame checkWords(List<String> wordList);
}

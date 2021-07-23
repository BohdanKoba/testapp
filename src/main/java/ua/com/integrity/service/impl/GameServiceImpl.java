package ua.com.integrity.service.impl;

import org.springframework.stereotype.Service;
import ua.com.integrity.bean.WordGame;
import ua.com.integrity.service.GameService;

import java.util.ArrayList;
import java.util.List;

/**
 * WordGame service class implementation.
 */
@Service
public class GameServiceImpl implements GameService {
    /**
     * Checks the correctness of the WordGame results.
     * Returns WordGame object with words that were used in the game right.
     *
     * @param wordList list of words to check
     * @return WordGame object with words that were used in the game right
     */
    @Override
    public WordGame checkWords(List<String> wordList) {
        List<String> words = new ArrayList<>();
        if (!wordList.get(0).isEmpty()) {
            words.add(wordList.get(0));
            for (int i = 0; i < wordList.size() - 1; i++) {
                String previousWord = wordList.get(i);
                String nextWord = wordList.get(i + 1);
                char lastCharacter = previousWord.charAt(previousWord.length() - 1);
                if (nextWord.startsWith(String.valueOf(lastCharacter))) {
                    words.add(nextWord);
                } else {
                    break;
                }
            }
        }
        return new WordGame(words);
    }
}

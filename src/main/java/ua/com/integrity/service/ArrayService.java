package ua.com.integrity.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayService {
    public String[] validateArray(String[] array) {
        List<String> words = new ArrayList<>();
        if (!array[0].isEmpty()) {
            words.add(array[0]);
            for (int i = 0; i < array.length - 1; i++) {
                String previousWord = array[i];
                String nextWord = array[i + 1];
                char lastCharacter = previousWord.charAt(previousWord.length() - 1);
                if (nextWord.startsWith(String.valueOf(lastCharacter))) {
                    words.add(nextWord);
                } else {
                    break;
                }
            }
        }
        return words.toArray(new String[0]);
    }
}

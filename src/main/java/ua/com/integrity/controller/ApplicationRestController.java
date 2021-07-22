package ua.com.integrity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.integrity.bean.WordArray;
import ua.com.integrity.service.ArrayService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class ApplicationRestController {
    private final ArrayService service;

    @RequestMapping("/check-words")
    public WordArray getArray(@RequestBody WordArray input) {
        String[] words = service.validateArray(input.getWords());
        return new WordArray(words);
    }
}
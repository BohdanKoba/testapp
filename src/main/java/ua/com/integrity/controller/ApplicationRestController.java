package ua.com.integrity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.integrity.bean.WordGame;
import ua.com.integrity.service.GameService;

/**
 * Controller of the application.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class ApplicationRestController {
    /**
     * Service for working with request data.
     */
    private final GameService service;

    /**
     * Returns validated results of WordGame.
     *
     * @param game a WordGame object passed in the request
     * @return validated results of WordGame
     */
    @RequestMapping("/check-words")
    public WordGame validateGame(@RequestBody WordGame game) {
        return service.checkWords(game.getWords());
    }
}
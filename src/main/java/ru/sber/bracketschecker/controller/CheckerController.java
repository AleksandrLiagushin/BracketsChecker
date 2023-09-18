package ru.sber.bracketschecker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import ru.sber.bracketschecker.util.BracketsChecker;
import ru.sber.bracketschecker.util.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class CheckerController {

    @GetMapping("/checkBrackets")
    public String checkBrackets(@RequestBody String json) throws JsonProcessingException {
        log.info("Get request from user {}", json);
        String text = JsonParser.getText(json);
        boolean isCorrect = BracketsChecker.isCorrect(text);
        log.info("Checker response: {}", isCorrect);
        return "{\"isCorrect\": " + isCorrect + "}";
    }
}

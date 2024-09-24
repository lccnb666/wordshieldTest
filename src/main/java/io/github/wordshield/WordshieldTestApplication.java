package io.github.wordshield;

import io.github.avidbyte.SensitiveWordFilter;
import io.github.avidbyte.SensitiveWordResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WordshieldTestApplication {

    public WordshieldTestApplication(SensitiveWordFilter sensitiveWordFilter) {
        this.sensitiveWordFilter = sensitiveWordFilter;
    }

    public static void main(String[] args) {
        SpringApplication.run(WordshieldTestApplication.class, args);
    }

    private final SensitiveWordFilter sensitiveWordFilter;
    @GetMapping("/sensitive/filter")
    public String filterWord(@RequestParam String content) {
        SensitiveWordResult sensitiveWordResult = sensitiveWordFilter.checkAndFilter(content, "*");
        return sensitiveWordResult.getFilteredText();
    }
}

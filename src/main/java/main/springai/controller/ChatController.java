package main.springai.controller;

import lombok.RequiredArgsConstructor;
import main.springai.service.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {
    private final AiService aiService;

    @GetMapping("/chat")
    public String chatGet(@RequestBody String message) {
        return aiService.chat(message);
    }
}
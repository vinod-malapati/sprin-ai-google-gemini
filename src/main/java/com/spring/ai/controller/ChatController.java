package com.spring.ai.controller;

import com.spring.ai.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "chat";
    }

    @PostMapping("/chat")
    public String chat(
            @RequestParam String prompt,
            Model model) {

        String response = service.ask(prompt);

        model.addAttribute("prompt", prompt);
        model.addAttribute("response", response);

        return "chat";
    }
}
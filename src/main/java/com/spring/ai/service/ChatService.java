package com.spring.ai.service;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private Client client;

    public String ask(String prompt) {
        return client.models.generateContent(
                "gemini-2.5-flash",
                prompt,
                null
        ).text();
    }
}
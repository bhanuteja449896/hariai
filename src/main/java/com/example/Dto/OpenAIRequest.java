package com.example.Dto;

import java.util.List;
import java.util.Map;

public class OpenAIRequest {

    private String model = "gpt-3.5-turbo";
    private List<Map<String, String>> messages;

    public OpenAIRequest(String userMessage) {
        this.messages = List.of(Map.of("role", "user", "content", userMessage));
    }
    
}

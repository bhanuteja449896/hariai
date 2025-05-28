package com.example.Dto;

import java.util.List;

public class OpenAIResponse {
    public List<Choice> choices;

    public static class Choice {
        public Message message;
    }

    public static class Message {
        public String role;
        public String content;
    }
}


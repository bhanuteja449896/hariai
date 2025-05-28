package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OpenAIService;

@RestController
public class OpenAIController {

    
    private final OpenAIService openAIService;

    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }
    @GetMapping("/test1")
    String hello() {
      return "Hello " + "name"  + "!";
    }
    
    @GetMapping("/ask")
    public ResponseEntity<String> ask(@RequestParam String prompt) {
        String response = openAIService.getChatResponse(prompt);
        return ResponseEntity.ok(response);
    }
}

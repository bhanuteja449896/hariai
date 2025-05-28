package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Dto.OpenAIRequest;
import com.example.Dto.OpenAIResponse;
@Service
public class OpenAIService {
    
    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getChatResponse(String userPrompt) {
        String url = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        OpenAIRequest request = new OpenAIRequest(userPrompt);

        HttpEntity<OpenAIRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<OpenAIResponse> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            OpenAIResponse.class
        );

        return response.getBody().choices.get(0).message.content;
    }
}

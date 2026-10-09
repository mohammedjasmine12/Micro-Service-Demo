package com.example.student_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CourseWebClient {
    private final WebClient.Builder builder;
    public CourseWebClient(WebClient.Builder builder) { this.builder = builder; }
    
    public Course getCourseById(Long id) {
        return builder.build().get()
                .uri("http://localhost:8081/courses/" + id)
                .retrieve().bodyToMono(Course.class).block();
    }
}
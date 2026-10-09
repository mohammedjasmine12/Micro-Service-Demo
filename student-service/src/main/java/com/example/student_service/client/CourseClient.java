package com.example.student_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service", url = "http://localhost:8081")
public interface CourseClient {
    @GetMapping("/courses/{id}")
    Course getCourseById(@PathVariable("id") Long id);
}
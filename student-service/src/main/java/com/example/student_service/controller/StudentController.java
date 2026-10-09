package com.example.student_service.controller;

import com.example.student_service.client.Course;
import com.example.student_service.client.CourseClient;
import com.example.student_service.client.CourseWebClient;
import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired private StudentRepository repository;
    @Autowired private CourseClient courseClient;
    @Autowired private RestTemplate restTemplate;
    @Autowired private CourseWebClient courseWebClient;

    @PostMapping
    public Student save(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    // Main output - Feign
    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        Student student = repository.findById(id).orElse(null);
        Course course = null;
        if (student != null) {
            course = courseClient.getCourseById(student.getCourseId());
        }
        return new StudentResponse(student, course);
    }

    // Extra for sir - RestTemplate
    @GetMapping("/{id}/rest")
    public StudentResponse getByRest(@PathVariable Long id) {
        Student student = repository.findById(id).orElse(null);
        Course course = restTemplate.getForObject("http://localhost:8081/courses/" + student.getCourseId(), Course.class);
        return new StudentResponse(student, course);
    }

    // Extra for sir - WebClient
    @GetMapping("/{id}/webclient")
    public StudentResponse getByWebClient(@PathVariable Long id) {
        Student student = repository.findById(id).orElse(null);
        Course course = courseWebClient.getCourseById(student.getCourseId());
        return new StudentResponse(student, course);
    }
}
package com.example.student_service.controller;

import com.example.student_service.client.Course;
import com.example.student_service.entity.Student;

public class StudentResponse {
    private Student student;
    private Course course;
    
    public StudentResponse() {}
    public StudentResponse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
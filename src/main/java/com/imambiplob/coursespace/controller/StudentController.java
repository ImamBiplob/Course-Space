package com.imambiplob.coursespace.controller;

import com.imambiplob.coursespace.dto.StudentProfile;
import com.imambiplob.coursespace.dto.StudentRegister;
import com.imambiplob.coursespace.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentProfile addStudent(@RequestBody StudentRegister studentRegister) {
        return studentService.saveStudent(studentRegister);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentProfile getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }
}

package com.imambiplob.coursespace.controller;

import com.imambiplob.coursespace.entity.Course;
import com.imambiplob.coursespace.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course course1 = courseService.addCourse(course);
        if(course1.getId()>0) {
            return new ResponseEntity<>(course1, HttpStatus.OK);
        }
        return new ResponseEntity<>("Course Already In Listed",HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourses();
    }


}

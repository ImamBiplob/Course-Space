package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.entity.Course;
import com.imambiplob.coursespace.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(long id) {
        if(courseRepository.findById(id).isPresent())
            return courseRepository.findById(id).get();
        return null;
    }
}

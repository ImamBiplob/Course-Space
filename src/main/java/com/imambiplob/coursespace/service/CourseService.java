package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.entity.Course;
import com.imambiplob.coursespace.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        Optional<Course> course1 = courseRepository.findByCourseCode(course.getCourseCode());
        if(course1.isPresent()) {
            return new Course();
        }
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

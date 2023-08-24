package com.imambiplob.coursespace.repository;

import com.imambiplob.coursespace.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

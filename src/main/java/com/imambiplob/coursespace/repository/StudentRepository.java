package com.imambiplob.coursespace.repository;

import com.imambiplob.coursespace.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

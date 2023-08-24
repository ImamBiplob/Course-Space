package com.imambiplob.coursespace.repository;

import com.imambiplob.coursespace.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}

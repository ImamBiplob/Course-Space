package com.imambiplob.coursespace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CourseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToMany
    @JoinTable(name = "requested_courses",
            joinColumns = @JoinColumn(name = "course_request_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> selectedCourses;
    private LocalDateTime requestTime = LocalDateTime.now();
    private boolean isApproved = false;
    private String status = isApproved ? "Approved" : "Pending";
}

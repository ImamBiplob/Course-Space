package com.imambiplob.coursespace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentSemester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String semesterName;
    @ManyToMany
    @JoinTable(name = "student_semester_courses",
            joinColumns = @JoinColumn(name = "student_semester_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> coursesTaken;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payslip_id")
    private Payslip payslip;
}

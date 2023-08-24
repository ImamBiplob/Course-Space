package com.imambiplob.coursespace.controller;

import com.imambiplob.coursespace.dto.SemesterDTO;
import com.imambiplob.coursespace.entity.Semester;
import com.imambiplob.coursespace.service.SemesterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {
    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping
    public Semester addSemester(@RequestBody SemesterDTO semesterDTO) {
        return semesterService.addSemester(semesterDTO);
    }

    @GetMapping
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{id}")
    public Semester getSemester(@PathVariable long id) {
        return semesterService.getSemester(id);
    }
}

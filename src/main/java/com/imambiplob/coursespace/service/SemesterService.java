package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.dto.SemesterDTO;
import com.imambiplob.coursespace.entity.Semester;
import com.imambiplob.coursespace.repository.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Semester addSemester(SemesterDTO semesterDTO) {
        Semester semester = new Semester();
        semester.setSemesterName(semesterDTO.getSemesterName());
        semester.setSemesterFee(semesterDTO.getSemesterFee());
        semester.setCreditLimit(semesterDTO.getCreditLimit());
        return semesterRepository.save(semester);
    }

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getSemester(long id) {
        if(semesterRepository.findById(id).isPresent())
            return semesterRepository.findById(id).get();
        return null;
    }
}

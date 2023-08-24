package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.dto.SemesterDTO;
import com.imambiplob.coursespace.entity.Course;
import com.imambiplob.coursespace.entity.Semester;
import com.imambiplob.coursespace.repository.CourseRepository;
import com.imambiplob.coursespace.repository.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    private final CourseRepository courseRepository;

    public SemesterService(SemesterRepository semesterRepository, CourseRepository courseRepository) {
        this.semesterRepository = semesterRepository;
        this.courseRepository = courseRepository;
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

    public Object addCoursesToSemester(long id, List<String > courseCode) {
        Optional<Semester> semester = semesterRepository.findById(id);
        if (semester.isPresent()){
            Semester semester1 = semester.get();
            List<Course> semesterCourseList = semester1.getCourses();
            for (String code : courseCode) {
                Optional<Course> course = courseRepository.findByCourseCode(code);
                course.ifPresent(semesterCourseList::add);
            }
            semester1.setCourses(semesterCourseList);
            return semesterRepository.save(semester1);
        }
        return new Semester();
    }
}

package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.dto.StudentProfile;
import com.imambiplob.coursespace.dto.StudentRegister;
import com.imambiplob.coursespace.entity.Student;
import com.imambiplob.coursespace.entity.User;
import com.imambiplob.coursespace.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static StudentProfile convertStudentToStudentProfile(Student student) {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setId(student.getId());
        studentProfile.setName(student.getUser().getName());
        studentProfile.setEmail(student.getUser().getEmail());
        studentProfile.setPhone(student.getPhone());
        studentProfile.setDob(student.getDob());

        return studentProfile;
    }

    public StudentProfile saveStudent(StudentRegister studentRegister) {
        Student student = new Student();
        User user = new User();
        user.setName(studentRegister.getName());
        user.setEmail(studentRegister.getEmail());
        user.setPassword(studentRegister.getPassword());
        user.setRole("Student");
        student.setUser(user);
        student.setDob(studentRegister.getDob());
        student.setPhone(studentRegister.getPhone());
        student = studentRepository.save(student);
        return convertStudentToStudentProfile(student);
    }

    public List<StudentProfile> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentProfile> studentProfiles = new ArrayList<>();
        for(Student student:students) {
            StudentProfile  studentProfile = convertStudentToStudentProfile(student);
            studentProfiles.add(studentProfile);
        }

        return studentProfiles;
    }

    public StudentProfile getStudent(long id) {
        return convertStudentToStudentProfile(studentRepository.findById(id).get());
    }
}

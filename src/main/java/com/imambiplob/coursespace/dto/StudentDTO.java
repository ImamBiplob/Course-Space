package com.imambiplob.coursespace.dto;

import com.imambiplob.coursespace.entity.Student;
import com.imambiplob.coursespace.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private LocalDate dob;
    private String phone;
    private String name;
    private String email;
    private String password;
    private List<Long> courseId;

    public static StudentDTO form(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getUser().getName());
        studentDTO.setEmail(student.getUser().getEmail());
        studentDTO.setPassword(student.getUser().getPassword());
        studentDTO.setDob(student.getDob());
        studentDTO.setPhone(student.getPhone());
        return studentDTO;
    }
}

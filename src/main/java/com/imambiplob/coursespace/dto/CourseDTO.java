package com.imambiplob.coursespace.dto;

import com.imambiplob.coursespace.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private long id;
    private String courseCode;
    private String courseName;
    private int courseFee;
    private double credit;
    private int availableSeats;

    public static CourseDTO form(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseFee(course.getCourseFee());
        courseDTO.setCredit(course.getCredit());
        courseDTO.setAvailableSeats(course.getAvailableSeats());
        return courseDTO;
    }
}

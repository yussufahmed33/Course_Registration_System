package com.HotelReservation.HotelReservation.Model;


import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.util.AbstractSet.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
//@Data
@Table
@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;
    private String studentName;
//    @ManyToMany(mappedBy = "student")
////    @JoinTable(
////            name = "Student_Course",
////            joinColumns = @JoinColumn(name = "Student_Id"),
////    inverseJoinColumns = @JoinColumn(name = "Course_Id"))
@ManyToMany(mappedBy = "students")
    private Set<CourseModel> registredCourses = new HashSet<>();
    public void addCourse(CourseModel course) {
        registredCourses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(CourseModel course) {
        registredCourses.remove(course);
        course.getStudents().remove(this);
    }

    public Collection<Object> getRegistredCourses() {

        return java.util.List.of();
    }
}

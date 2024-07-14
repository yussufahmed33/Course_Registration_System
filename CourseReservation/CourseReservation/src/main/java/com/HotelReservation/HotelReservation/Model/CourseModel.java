package com.HotelReservation.HotelReservation.Model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;



//import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Data
@Table
@Entity
public class CourseModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;


//@ManyToMany(mappedBy = "registeredCourse")
@ManyToMany

    @JoinTable(
            name = "Student_Course",
            joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    public Set<StudentModel> students = new HashSet<>();
//    public void addStudent(StudentModel student) {
//        students.add(student);
//        student.getRegistredCourses().add(this);
//    }
//
//    public void removeStudent(StudentModel student) {
//        students.remove(student);
//        student.getRegistredCourses().remove(this);
//    }
}

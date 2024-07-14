package com.HotelReservation.HotelReservation.Service;

import com.HotelReservation.HotelReservation.Model.CourseModel;
import com.HotelReservation.HotelReservation.Model.StudentModel;
import com.HotelReservation.HotelReservation.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseService courseService;
    public List<StudentModel> findAllStudents(){
        return studentRepository.findAll();
    }
    public StudentModel findStudentById(int StudentId){
        return studentRepository.findById(StudentId).orElse(null);
    }
    public void addStudent(StudentModel student){
        studentRepository.save(student);
    }
    public void RegisterStudentForCourse(int CourseId, int StudentId){
        StudentModel student = findStudentById(StudentId);
        CourseModel course= courseService.findCourseByCode(CourseId);
        if(student !=null && course != null && course.getEnrolledStudents()<course.getCapacity()) {
            student.addCourse(course);
            course.setEnrolledStudents(course.getEnrolledStudents()+1);

    studentRepository.save(student);
    courseService.addCourse(course);



        }
    }
    public void removeStudentFromCourse(int CourseId, int StudentId){
        StudentModel student = findStudentById(StudentId);
        CourseModel courseModel= courseService.findCourseByCode(CourseId);
        if(student!=null && courseModel!=null){
            student.getRegistredCourses().remove(courseModel);
            courseModel.getStudents().remove(student);


            studentRepository.save(student);
            courseService.addCourse(courseModel);
        }
    }
}

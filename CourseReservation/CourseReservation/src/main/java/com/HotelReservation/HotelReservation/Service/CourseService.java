package com.HotelReservation.HotelReservation.Service;

import com.HotelReservation.HotelReservation.Model.CourseModel;
import com.HotelReservation.HotelReservation.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
@Autowired
    private CourseRepository courseRepository;
public List<CourseModel> listAvalibleCourses(){
    return courseRepository.findAll();
    }
    public CourseModel findCourseByCode(int CourseCode){
    return courseRepository.findById(CourseCode).orElse(null);
    }
    public void addCourse(CourseModel course){
    courseRepository.save(course);

    }
}

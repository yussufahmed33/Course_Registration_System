package com.HotelReservation.HotelReservation.Controller;

import com.HotelReservation.HotelReservation.Model.CourseModel;
import com.HotelReservation.HotelReservation.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/courses")
    public List<CourseModel> listAvalibleCourses(){
        return courseService.listAvalibleCourses();
    }
//    @GetMapping("/addcourse")
//    public String addCourse(){
//        return "addCourse";
//    }
//    @PostMapping("/addcourse")
//    public void addCourse(@RequestBody CourseModel course){
//        courseService.addCourse(course);
//    }
    @GetMapping("/addcourse")
    public String addcourse(Model model) {
        return "addcourse";
    }
    @PostMapping("/addcourse")
    public void addcourse(@ModelAttribute("courseModel") CourseModel courseModel) {
        courseService.addCourse(courseModel);
        // return "redirect:/registerstudents";
    }
}

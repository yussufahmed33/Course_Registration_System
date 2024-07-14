package com.HotelReservation.HotelReservation.Controller;

import com.HotelReservation.HotelReservation.Model.CourseModel;
import com.HotelReservation.HotelReservation.Model.StudentModel;
import com.HotelReservation.HotelReservation.Service.CourseService;
import com.HotelReservation.HotelReservation.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
//    @GetMapping("/students")
//    public List<StudentModel> getAllStudents() {
//        return studentService.findAllStudents();
//    }
////    @GetMapping("/register")
////    public String register(){
////        return "studentRegisterForCourse";
////    }
////    @GetMapping("/addstudent")
////    public String addStudent(){
////        return "addstudent";
////    }
//    @GetMapping("addstudent")
//    public String addStudent(Model model) {;
//        return "addstudent";
//    }
//    @PostMapping("/addstudent")
//    public void addStudent(@RequestBody StudentModel student) {
//        studentService.addStudent(student);
//       // model.addAttribute("message", "Student added successfully");
//       // return"result";
//    }
//    @GetMapping("student/register")
//    public String registerStudent(Model model) {
//        model.addAttribute("studentId","0");
//        model.addAttribute("courseCode","0");
//        return "registerstudents";
//    }
//    @PutMapping("/students/{studentId}/courses/{courseCode}")
//    public void registerCourse(@PathVariable int studentId, @PathVariable int courseCode) {
//         studentService.RegisterStudentForCourse(courseCode,studentId);
//    }
//    @DeleteMapping("/{studentId}/courses/{courseCode}")
//    public void deleteStudentFromCourse(@PathVariable int studentId, @PathVariable int courseCode) {
//        studentService.removeStudentFromCourse(courseCode,studentId);
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/students")
public List<StudentModel> getallstudents(Model model) {
    return studentService.findAllStudents();
}
    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        return "addstudent";
    }
    @PostMapping("addstudent")
    public String addStudent(@ModelAttribute("studentModel") StudentModel studentModel) {
        studentService.addStudent(studentModel);
        return "redirect:/addstudent";
    }
    @GetMapping("/register")
public String register(Model model) {
    return "registerstudents";
    }
@PostMapping("register")
    public String register(@RequestParam int courseCode,@RequestParam int studentId) {
studentService.RegisterStudentForCourse(courseCode, studentId);
return "redirect:/students/" + studentId + "/courses/" + courseCode + "/success";
}
//@GetMapping("/students/{studentId}/courses/{courseCode}")
//public String redirect(){
//    return "registerstudents";
//}
@GetMapping("/students/{studentId}/courses/{courseCode}/success")
    public String registerStudent() {

    return "registrationsuccess";
}
    @PutMapping("/students/{studentId}/courses/{courseCode}")
    public void registerCoursePut(@PathVariable int studentId, @PathVariable int courseCode) {
        studentService.RegisterStudentForCourse(courseCode, studentId);
    }
}

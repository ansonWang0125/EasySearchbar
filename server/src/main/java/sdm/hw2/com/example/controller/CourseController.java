package sdm.hw2.com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdm.hw2.com.example.model.CourseModel;
import sdm.hw2.com.example.service.CourseService;

@RestController
public class CourseController {
    @Autowired
    CourseModel CourseModel;
    
    @Autowired
    CourseService CourseService;

    @RequestMapping("/api/student/addCourse")
    public String hello(){
        CourseModel = new CourseModel();
        CourseModel.setId((long)1234);
        CourseModel.setSID("0001");
        CourseModel.setCourse("Intro. to ML");
        CourseService.addCourse(CourseModel);
        return "New Course added";
    }
}

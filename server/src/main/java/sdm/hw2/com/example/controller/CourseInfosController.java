package sdm.hw2.com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdm.hw2.com.example.model.CourseInfosModel;
import sdm.hw2.com.example.service.CourseInfosService;

@RestController
public class CourseInfosController {
    @Autowired
    CourseInfosModel CourseModel;
    
    @Autowired
    CourseInfosService CourseService;

    @RequestMapping("/api/student/addCourse")
    public String hello(){
        CourseModel = new CourseInfosModel();
        CourseModel.setId((long)1234);
        CourseModel.setSID("0001");
        CourseModel.setCourse("Intro. to ML");
        CourseModel.setSemester("2021s");
        CourseService.addCourse(CourseModel);
        return "New Course added";
    }
}

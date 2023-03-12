package sdm.hw2.com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdm.hw2.com.example.model.SemesterModel;
import sdm.hw2.com.example.service.SemesterService;

@RestController
public class SemesterController {
    @Autowired
    SemesterModel SemesterModel;
    
    @Autowired
    SemesterService SemesterService;

    @RequestMapping("/api/student/addSemester")
    public String hello(){
        SemesterModel = new SemesterModel();
        SemesterModel.setId((long)1234);
        SemesterModel.setSID("0001");
        SemesterModel.setSemester("2021s");
        SemesterService.addSemester(SemesterModel);
        return "New Semester added";
    }
}

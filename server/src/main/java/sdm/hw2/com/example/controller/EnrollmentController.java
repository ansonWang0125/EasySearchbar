package sdm.hw2.com.example.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import sdm.hw2.com.example.model.EnrollmentModel;
import sdm.hw2.com.example.service.EnrollmentService;
import sdm.hw2.com.example.RequestObj.SearchObject;
import sdm.hw2.com.example.RequestObj.InfoObject;
import sdm.hw2.com.example.ResponseObj.SemesterObj;
import sdm.hw2.com.example.ResponseObj.CourseObj;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
        @Autowired
		EnrollmentModel EnrollmentModel;
        
		@Autowired
		EnrollmentService EnrollmentService;
		@GetMapping("/addStudent")
	    public String hello(){
	    	EnrollmentModel = new EnrollmentModel();
	    	EnrollmentModel.setSID("0001");
	    	EnrollmentModel.setName("Steve");
	    	EnrollmentService.addStudent(EnrollmentModel);
	        return "New Student added";
	    }
	    
	    @PostMapping("/search")
	    public Map<String, Object>  search(@RequestBody SearchObject request){
	    	String searchStr = request.getSearchStr();
	    	List<SemesterObj> enrollments = EnrollmentService.searchStudent(searchStr);
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	if (!enrollments.isEmpty()) {
	    		map.put("success", true);
	    		map.put("studentInform", enrollments);
	    	} else {
	    		map.put("success", false);
	    	}
	        return map;
	    }
	    
	    @PostMapping("/inform")
	    public Map<String, Object>  inform(@RequestBody InfoObject request){
	    	String SID = request.getSID();
			String Semester = request.getSemester();
	    	List<CourseObj> enrollments = EnrollmentService.studentInfo(SID, Semester);
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	if (!enrollments.isEmpty()) {
	    		map.put("success", true);
	    		map.put("studentInform", enrollments);
	    	} else {
	    		map.put("success", false);
	    	}
//	    	String res = JSON.toJSONString(map);
	        return map;
	    }
}

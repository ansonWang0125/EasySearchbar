package sdm.hw2.com.example.service;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sdm.hw2.com.example.model.EnrollmentModel;
import sdm.hw2.com.example.repository.EnrollmentRepo;
import sdm.hw2.com.example.ResponseObj.SemesterObj;
import sdm.hw2.com.example.ResponseObj.CourseObj;

@Service
public class EnrollmentService {
    
    @Autowired
	EnrollmentRepo EnrollmentRepo;

	public void addStudent(EnrollmentModel enrollments){
		EnrollmentRepo.addStudent(enrollments);
	}
	
	public List<SemesterObj> searchStudent(String search){
		List<SemesterObj> enrollments = EnrollmentRepo.searchStudent(search);
		return enrollments;
	}
	
	public List<CourseObj> studentInfo(String SID, String Semester){
		List<CourseObj> enrollments = EnrollmentRepo.studentInfo(SID, Semester);
		return enrollments;
	}
}

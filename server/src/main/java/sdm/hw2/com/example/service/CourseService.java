package sdm.hw2.com.example.service;


//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sdm.hw2.com.example.model.CourseModel;
import sdm.hw2.com.example.repository.CourseRepo;

@Service
public class CourseService {
    
    @Autowired
	CourseRepo CourseRepo;

    public void addCourse(CourseModel CourseModel){
		CourseRepo.addCourse(CourseModel);
	}
}

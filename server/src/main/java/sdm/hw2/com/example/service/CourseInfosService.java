package sdm.hw2.com.example.service;


//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sdm.hw2.com.example.model.CourseInfosModel;
import sdm.hw2.com.example.repository.CourseInfosRepo;

@Service
public class CourseInfosService {
    
    @Autowired
	CourseInfosRepo CourseRepo;

    public void addCourse(CourseInfosModel CourseModel){
		CourseRepo.addCourse(CourseModel);
	}
}

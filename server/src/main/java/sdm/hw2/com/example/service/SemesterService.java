package sdm.hw2.com.example.service;


//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sdm.hw2.com.example.model.SemesterModel;
import sdm.hw2.com.example.repository.SemesterRepo;

@Service
public class SemesterService {
    
    @Autowired
	SemesterRepo SemesterRepo;

    public void addSemester(SemesterModel SemesterModel){
		SemesterRepo.addSemester(SemesterModel);
	}
}

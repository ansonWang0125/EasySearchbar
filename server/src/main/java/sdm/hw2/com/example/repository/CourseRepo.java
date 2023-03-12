package sdm.hw2.com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sdm.hw2.com.example.model.CourseModel;

@Repository
public class CourseRepo {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addCourse(CourseModel SemesterModel){
	    jdbcTemplate.update("INSERT INTO Courses(ID, SID, Course) " + "VALUES (?,?,?)", SemesterModel.getId(), SemesterModel.getSID(), SemesterModel.getCourse());
	}
}

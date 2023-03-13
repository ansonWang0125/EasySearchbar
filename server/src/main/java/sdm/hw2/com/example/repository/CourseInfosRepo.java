package sdm.hw2.com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sdm.hw2.com.example.model.CourseInfosModel;

@Repository
public class CourseInfosRepo {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addCourse(CourseInfosModel CourseInfosModel){
	    jdbcTemplate.update("INSERT INTO CourseInfos(ID, SID, Course, Semester) " + "VALUES (?,?,?,?)", CourseInfosModel.getId(), CourseInfosModel.getSID(), CourseInfosModel.getCourse(), CourseInfosModel.getSemester());
	}
}

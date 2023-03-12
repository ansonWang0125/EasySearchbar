package sdm.hw2.com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sdm.hw2.com.example.model.SemesterModel;

@Repository
public class SemesterRepo {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addSemester(SemesterModel SemesterModel){
	    jdbcTemplate.update("INSERT INTO Semesters(ID, SID, Semester) " + "VALUES (?,?,?)", SemesterModel.getId(), SemesterModel.getSID(), SemesterModel.getSemester());
	}
}

package sdm.hw2.com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sdm.hw2.com.example.model.StudentInfosModel;
import sdm.hw2.com.example.ResponseObj.SemesterObj;
import sdm.hw2.com.example.ResponseObj.CourseObj;
import java.util.*;

@Repository
public class StudentInfosRepo {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addStudent(StudentInfosModel studentModel){
	    jdbcTemplate.update("INSERT INTO StudentInfos(SID, NAME) " + "VALUES (?,?)", studentModel.getSID(), studentModel.getName());
	}
	
	public List<SemesterObj> searchStudent(String searchStr){
		String sql = "Select CourseInfos.Semester as Semester, StudentInfos.SID as SID, StudentInfos.NAME as NAME from StudentInfos LEFT JOIN CourseInfos ON StudentInfos.SID = CourseInfos.SID where StudentInfos.SID = \"" + searchStr + "\" OR StudentInfos.NAME = \"" + searchStr+"\"";
		List<SemesterObj> enrollments = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			SemesterObj obj = new SemesterObj();
			obj.setSemester((String) row.get("Semester"));
            obj.setSID((String) row.get("SID"));
            obj.setNAME((String) row.get("NAME"));
            enrollments.add(obj);
        }
		return enrollments;
	}
	
	public List<CourseObj> studentInfo(String SID, String Semester){
		String sql = "Select CourseInfos.Semester as Semester, StudentInfos.SID as SID, StudentInfos.NAME as NAME, CourseInfos.Course as Course from StudentInfos LEFT JOIN CourseInfos ON StudentInfos.SID = CourseInfos.SID where StudentInfos.SID = \"" + SID + "\" and CourseInfos.Semester = \"" + Semester+"\"";
		List<CourseObj> enrollments = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			CourseObj obj = new CourseObj();

            obj.setSID((String) row.get("SID"));
            obj.setNAME((String) row.get("NAME"));
			obj.setSemester((String) row.get("Semester"));
			obj.setCourse((String) row.get("Course"));
            enrollments.add(obj);
        }
		return enrollments;
	}


}


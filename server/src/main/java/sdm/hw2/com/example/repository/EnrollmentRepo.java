package sdm.hw2.com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sdm.hw2.com.example.model.EnrollmentModel;
import sdm.hw2.com.example.ResponseObj.SemesterObj;
import sdm.hw2.com.example.ResponseObj.CourseObj;
import java.util.*;

@Repository
public class EnrollmentRepo {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addStudent(EnrollmentModel studentModel){
	    jdbcTemplate.update("INSERT INTO Enrollments(SID, NAME) " + "VALUES (?,?)", studentModel.getSID(), studentModel.getName());
	}
	
	public List<SemesterObj> searchStudent(String searchStr){
		String sql = "Select Semesters.Semester as Semester, Enrollments.SID as SID, Enrollments.NAME as NAME from Enrollments LEFT JOIN Semesters ON Semesters.SID = Enrollments.SID where Enrollments.SID = \"" + searchStr + "\" OR Enrollments.NAME = \"" + searchStr+"\"";
		List<SemesterObj> enrollments = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			SemesterObj obj = new SemesterObj();
			obj.setSemester((String) row.get("Semester"));
            obj.setSID((String) row.get("SID"));
            obj.setNAME((String) row.get("NAME"));
			// Spring returns BigDecimal, need convert
//            obj.setAge(((BigDecimal) row.get("AGE")).intValue()); 
//            obj.setCreatedDate(((Timestamp) row.get("CREATED_DATE")).toLocalDateTime());
            enrollments.add(obj);
        }
		return enrollments;
	}
	
	public List<CourseObj> studentInfo(String SID, String Semester){
		String sql = "Select Semesters.Semester as Semester, Enrollments.SID as SID, Enrollments.NAME as NAME, Courses.Course as Course from Enrollments LEFT JOIN Semesters ON Semesters.SID = Enrollments.SID LEFT JOIN Courses ON Courses.SID = Enrollments.SID where Enrollments.SID = \"" + SID + "\" and Semesters.Semester = \"" + Semester+"\"";
		List<CourseObj> enrollments = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			CourseObj obj = new CourseObj();

            obj.setSID((String) row.get("SID"));
            obj.setNAME((String) row.get("NAME"));
			obj.setSemester((String) row.get("Semester"));
			obj.setCourse((String) row.get("Course"));
			// Spring returns BigDecimal, need convert
//            obj.setAge(((BigDecimal) row.get("AGE")).intValue()); 
//            obj.setCreatedDate(((Timestamp) row.get("CREATED_DATE")).toLocalDateTime());
            enrollments.add(obj);
        }
		return enrollments;
	}


}


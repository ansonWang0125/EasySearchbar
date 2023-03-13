package sdm.hw2.com.example.model;

import org.springframework.stereotype.Component;

@Component
public class CourseInfosModel {
    private Long id;
    private String SID;
    private String Course;
    private String Semester;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getSID() {
        return SID;
    }
    
    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getCourse() {
        return Course;
    }
    
    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getSemester() {
        return Semester;
    }
    
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
}

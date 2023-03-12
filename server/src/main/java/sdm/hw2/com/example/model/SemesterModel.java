package sdm.hw2.com.example.model;

import org.springframework.stereotype.Component;

@Component
public class SemesterModel {
    private Long id;
    private String SID;
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

    public String getSemester() {
        return Semester;
    }
    
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
}

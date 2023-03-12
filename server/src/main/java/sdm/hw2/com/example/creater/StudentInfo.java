package sdm.hw2.com.example.creater;

import javax.persistence.*;

public class StudentInfo {
    @Id
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="IDName", unique=true, nullable=false)
    private String IDName;

    @Column(name="Course", nullable=false)
    private String Course;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getIDName() {
        return IDName;
    }
    public void setIDName(String IDName) {
        this.IDName = IDName;
    }

    public String getCourse() {
        return IDName;
    }
    public void setCourse(String Course) {
        this.Course = Course;
    }
}

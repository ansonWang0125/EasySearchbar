package sdm.hw2.com.example.creater;


import javax.persistence.*;

@Entity
@Table(name="Enrollments")
public class Enrollments {
    @Id
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="IDName", unique=true, nullable=false)
    private String IDName;

    @Column(name="Semester", nullable=false)
    private String Semester;

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

    public String getSemester() {
        return IDName;
    }
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
}

package sdm.hw2.com.example.RequestObj;

public class InfoObject {
    private String SID;
    private String Semester;

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


    @Override
    public String toString() {
        return "InfoObject [SID=" + SID + "]";
    }
}

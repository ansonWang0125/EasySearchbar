package sdm.hw2.com.example.model;

import org.springframework.stereotype.Component;

@Component
public class StudentInfosModel {
    private String SID;
    private String Name;

    public String getSID() {
        return SID;
    }
    
    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
}

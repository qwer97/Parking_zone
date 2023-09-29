package Industryacademic.project.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="STUDENT")
public class STUDENT {
    @Id
    private int Sno;  // primary key 선언
    @Getter
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Pno;

    public String getPno() {
        return Pno;
    }

    public void setPno(String pno) {
        Pno = pno;
    }

    private String Parking_ticket;

    public int getSno(){
        return Sno;
    }

    public void setSno(int Sno){
        this.Sno = Sno;
    }

}
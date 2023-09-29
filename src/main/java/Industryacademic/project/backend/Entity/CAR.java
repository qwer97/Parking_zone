package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="CAR")
public class CAR {
    @Id
    private String Cno;

    public String getCno() {
        return Cno;
    }
    public void setCno(String cno) {
        Cno = cno;
    }
    @ManyToOne
    @JoinColumn(name="Sno")
    private STUDENT s; //Sno Foreignkey 선언
    private String Class_info;
    private char Double_parking;

}



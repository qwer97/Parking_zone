package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="CAR")
public class CAR {
    @Id
    @Column(name = "Cno")
    private String cno;

    public String getcno() {
        return cno;
    }
    public void setcno(String cno) {
        cno = cno;
    }
    @ManyToOne
    @JoinColumn(name="Sno")
    private STUDENT s; //Sno Foreignkey 선언
    private String Class_info;
    public String getClass_info() {
        return Class_info;
    }
    public void setClass_info(String class_info) {
        Class_info = class_info;
    }

    private char Double_parking;

}



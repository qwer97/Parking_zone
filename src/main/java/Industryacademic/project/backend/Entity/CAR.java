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
    @Column(name = "class_info")
    private String class_info;
    public String getClass_info() {
        return class_info;
    }
    public void setClass_info(String class_info) {
        this.class_info = class_info;
    }
    @Column(name = "Double_parking")
    private char Double_parking;

    public void updateClass_info(String newClass_info) {
        this.class_info = newClass_info;
    }

}



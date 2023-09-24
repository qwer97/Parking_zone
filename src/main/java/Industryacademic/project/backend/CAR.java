package Industryacademic.project.backend;

import Industryacademic.project.backend.STUDENT;
import jakarta.persistence.*;

@Entity
@Table(name="CAR")
public class CAR {
    @Id
    private String Cno;
    @ManyToOne
    @JoinColumn(name="Sno")
    private STUDENT s; //Sno Foreignkey 선언
    private String Class_info;
    private char Double_parking;

}



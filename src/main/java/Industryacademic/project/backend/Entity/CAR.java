package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CAR")
@Getter

public class CAR {
    @Id
    @Column(name = "Cno")
    @Getter
    @Setter
    private String cno;

    @ManyToOne
    @JoinColumn(name="Sno")
    @Getter
    @Setter
    private STUDENT s; //Sno Foreignkey 선언

    @Column(name = "class_info")
    @Getter
    @Setter
    private String class_info;

    @Column(name = "Double_parking")
    @Getter
    @Setter
    private char Double_parking;

    public void updateClass_info(String newClass_info) {
        this.class_info = newClass_info;
    }

}



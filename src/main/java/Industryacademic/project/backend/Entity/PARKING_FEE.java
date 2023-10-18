package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PARKING_FEE")
public class PARKING_FEE {

    @Id
    @ManyToOne
    @JoinColumn(name="Mno")
    @Getter
    @Setter
    private MEMBER M; //Mno Foreignkey 선언


    @Column(name = "Fee")
    @Getter
    @Setter
    private int fee;

}

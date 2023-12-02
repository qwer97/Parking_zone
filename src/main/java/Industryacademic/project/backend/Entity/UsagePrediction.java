package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="Predict_Data")
public class UsagePrediction {

    @Id
    @Column(name="id")
    private int id;

    @Getter
    @Setter
    @Column(name="년도")
    private int Year;

    @Getter
    @Setter
    @Column(name="월")
    private int Month;

    @Getter
    @Setter
    @Column(name="일")
    private int Day;

    @Getter
    @Setter
    @Column(name="시간")
    private int time; //시간

    @Getter
    @Setter
    @Column(name="혼잡도")
    private Double precipitationAmount; //예측량

}


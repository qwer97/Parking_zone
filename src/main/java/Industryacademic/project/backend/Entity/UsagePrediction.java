package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="UsagePrediction")
public class UsagePrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private Date date; //날짜

    @Getter
    @Setter
    private String time; //시간

    @Getter
    @Setter
    private String weather; //날씨

    @Getter
    @Setter
    private Double precipitationAmount; //예측량

}


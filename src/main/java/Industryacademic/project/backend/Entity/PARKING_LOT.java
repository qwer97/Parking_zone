package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name ="PARKING_LOT")
public class PARKING_LOT {
    @Id
    private String Cno;

    @Column(name= "entry_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="dd,MM,yyyy hh:mm")
    private Date entryTime;

    @Column(name= "exit_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="dd,MM,yyyy hh:mm")
    private Date exitTime;

}

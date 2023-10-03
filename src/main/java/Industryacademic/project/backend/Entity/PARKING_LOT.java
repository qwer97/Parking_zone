package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp; // java.sql.Timestamp를 사용합니다.
//local data time으로 바꿀수도

@Entity
@Table(name ="PARKING_LOT")
public class PARKING_LOT {
    @Getter
    @Setter
    @Id
    @Column(name = "Cno")
    private String cno;

    @Column(name= "entry_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss") // 패턴 수정
    @Getter
    @Setter
    private Timestamp entryTime;


    @Column(name= "exit_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss") // 패턴 수정
    @Getter
    @Setter
    private Timestamp exitTime;

    // Getter와 Setter 메서드 추가

}


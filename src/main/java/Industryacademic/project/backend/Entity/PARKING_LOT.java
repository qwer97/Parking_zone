package Industryacademic.project.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp; // java.sql.Timestamp를 사용합니다.
//local data time으로 바꿀수도

@Entity
@Table(name ="PARKING_LOT")
public class PARKING_LOT {
    @Getter
    @Id
    @Column(name = "Cno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cno;

    public String getcno() {
        return cno;
    }

    public void setcno(String cno) {
        cno = cno;
    }


    @Column(name= "entry_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="dd/MM/yyyy HH:mm") // 패턴 수정
    private Timestamp entryTime;

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    @Column(name= "exit_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern ="dd/MM/yyyy HH:mm") // 패턴 수정
    private Timestamp exitTime;

    // Getter와 Setter 메서드 추가

}


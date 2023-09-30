package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ParkingEntryService {
    private final PARKING_LOTRepository p;

    @Autowired
    public ParkingEntryService(PARKING_LOTRepository P){
        this.p=P;
    }

    public void saveParkingEntry(String Cno){
        PARKING_LOT entry = new PARKING_LOT();

        LocalDateTime enter_time =LocalDateTime.now();

        entry.setcno(Cno);
        entry.setEntryTime(Timestamp.valueOf(enter_time));
        p.save(entry); //jpa 내부 기능으로 insert등이 자동으로 된다.
    }

}

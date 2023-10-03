package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest(classes = BackendApplication.class)
public class ParkingServiceTest {
    @Autowired
    private ParkingService L;

    @Autowired
    private PARKING_LOTRepository P;

    @Test
    public void TestParking(){

        String cno = "김3333";
        PARKING_LOT p = new PARKING_LOT();
        p.setCno(cno);

        L.Parking(cno);

    }

}

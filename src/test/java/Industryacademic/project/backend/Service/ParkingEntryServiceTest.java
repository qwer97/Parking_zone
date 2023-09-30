package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BackendApplication.class)
public class ParkingEntryServiceTest {

    @Autowired
    private ParkingEntryService p;

    @Test
    public void testParking(){
        String Cno = "곽9999";
        PARKING_LOT PL= new PARKING_LOT();

        PL.setcno(Cno);
        p.saveParkingEntry(Cno);

    }
}

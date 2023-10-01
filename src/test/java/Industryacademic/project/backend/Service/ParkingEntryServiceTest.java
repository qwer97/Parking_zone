package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BackendApplication.class)
public class ParkingEntryServiceTest {

    @InjectMocks

    private ParkingEntryService p;

    @Mock
    private PARKING_LOTRepository pp;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @Transactional
    public void testParking(){

        String cno = "근1111";
        LocalDateTime enterTime = LocalDateTime.now();
        PARKING_LOT park = new PARKING_LOT();

        park.setcno(cno);
        park.setEntryTime(Timestamp.valueOf(enterTime));
        p.saveParkingEntry(cno);

    }




}

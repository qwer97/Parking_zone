package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BackendApplication.class)
public class DoubleParkingServiceTest {

    @Autowired
    private DoubleParkingService L;

    @MockBean
    private CARRepository c;

    @MockBean
    private PARKING_LOTRepository p;

    @Test
    public void testDoubleParkingCheck(){
        String Cno ="마8888";
        CAR car = new CAR();
        PARKING_LOT parkingLot = new PARKING_LOT();
        car.setClass_info("Some info");

        when(p.findByCno(Cno)).thenReturn(parkingLot);
        when(c.findByCno(Cno)).thenReturn(car);

        // 메소드 호출
        Map<String, String> result = L.DoubleParking_Check(Cno);

        // 결과 검증
        assertTrue(result.containsKey("Clas_info"));
        assertEquals("Some info", result.get("Clas_info"));

    }


}

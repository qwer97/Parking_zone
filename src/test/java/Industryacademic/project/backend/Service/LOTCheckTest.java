package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class LOTCheckTest {

    @Autowired
    PARKING_LOTRepository PL;


    @Autowired
    Lot_CheckService lc;


    @Test
    public void lotchecktest(){
        System.out.println(lc.lotcheck());
    }
}

package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_FEE;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.MEMBERRepository;
import Industryacademic.project.backend.repository.PARKING_FEERepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class FeeCheckTest {

    @Autowired
    FeeCheckService FS;

    @Autowired
    CARRepository C;

    @Autowired
    PARKING_FEERepository PF;

    @Autowired
    PARKING_LOTRepository PL;

    @Autowired
    MEMBERRepository M;

    @Test
    public void testCheck(){
        String cno = "마8888";
        int mno = 2019125003;
        CAR c = new CAR();
        c.setCno(cno);

        PARKING_FEE p = new PARKING_FEE();

        p.setMno(mno);
        p.setC(c);

        FS.FeeCheck(mno,cno);


    }


}

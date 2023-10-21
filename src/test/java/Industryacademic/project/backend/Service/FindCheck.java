package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_FEE;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.PARKING_FEERepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class FindCheck {

    @Autowired
    CARRepository C;
    @Autowired
    PARKING_FEERepository PF;

    @Test
    public void checkfind(){
        int mno = 2019125003;
        CAR c = C.findByMemberMno(mno);

        System.out.println(c.getCno());
    }
    @Test
    public void checkpf(){
        int mno =2019125003;
        PARKING_FEE p =PF.findByMno(mno);

    }
}

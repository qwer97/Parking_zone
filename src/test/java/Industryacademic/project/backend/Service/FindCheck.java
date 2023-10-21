package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.repository.CARRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class FindCheck {

    @Autowired
    CARRepository C;

    @Test
    public void checkfind(){
        int mno = 2019125003;
        CAR c = C.findByMemberMno(mno);

        System.out.println(c.getCno());
    }
}

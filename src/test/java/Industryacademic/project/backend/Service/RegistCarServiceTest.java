package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
class RegisterCarServiceTest {

    @Autowired
    private CARRepository c;

    @Autowired
    private STUDENTRepository s;

    @Autowired
    private RegistCarService r;

    @Test
    void registerCar_test() {
        // given
        int sno = 2019125003;
        String cno = "12365";

        STUDENT student = new STUDENT();
        student.setSno(sno);
        CAR C = new CAR();
        C.setCno(cno);
        C.setS(student);

        r.registerCar(cno, sno);
    }
}

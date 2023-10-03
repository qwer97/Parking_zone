package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.Service.RegistCarService;
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
    private RegistCarService registerCarService;

    @Test
    void registerCar_studentExist_carRegistered() {
        // given
        int sno = 2019125003;
        String cno = "12345";

        STUDENT student = new STUDENT();
        student.setSno(sno);
        CAR C = new CAR();
        C.setCno(cno);
        C.setS(student);
        c.save(C);


    }
}

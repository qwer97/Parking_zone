package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class RegistStudentTest {

    @Autowired
    RegistStudentService R;

    @Autowired
    STUDENTRepository S;

    @Test
    public void RegistTest(){ //test에서는 no parameter
        STUDENT s = new STUDENT();
        int sno = 2019123002;
        String password ="zzgg";
        String pno = "010-2345-3667";

        s.setSno(sno);
        s.setPassword(password);
        s.setPno(pno);

        R.StudentRegistration(sno,password,pno);
    }
}

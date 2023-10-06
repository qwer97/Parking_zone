package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistStudentService {


    private final STUDENTRepository S;

    @Autowired
    public RegistStudentService(STUDENTRepository S){
        this.S =S;
    }

    @Transactional
    public void StudentRegistration(int sno,String password ,String pno){

        STUDENT s = new STUDENT();
        s.setSno(sno);
        s.setPassword(password);
        s.setPno(pno);

        S.save(s);
    }
}

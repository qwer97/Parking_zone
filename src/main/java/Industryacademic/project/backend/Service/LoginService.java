package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService { // 로그인 구현 , 추후에 spring security?
    private final STUDENTRepository R;
    @Autowired
    public LoginService(STUDENTRepository R){
        this.R = R;
    }

    public boolean login(int Sno, String password){
        STUDENT s =R.findBySnoAndPassword(Sno,password);

        return s!=null;
    }

}

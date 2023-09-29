package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.springframework.stereotype.Service;

@Service

public class LoginService {
    private final STUDENTRepository R;

    public LoginService(STUDENTRepository R){
        this.R = R;
    }

    public boolean login(int Sno, String password){
        STUDENT s =R.findBySnoAndPassword(Sno,password);

        return s!=null;
    }

}

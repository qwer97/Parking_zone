package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.repository.MEMBERRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistMEMBERService {

    private final MEMBERRepository M;

    @Autowired
    public RegistMEMBERService(MEMBERRepository M){
        this.M =M;
    }

    @Transactional
    public void MEMBERRegistration(int mno,String password ,String pno){

        MEMBER m = new MEMBER();
        m.setMno(mno);
        m.setPassword(password);
        m.setPno(pno);

        M.save(m);
    }
}

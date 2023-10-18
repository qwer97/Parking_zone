package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.repository.MEMBERRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyTicketService {

    private final MEMBERRepository M;

    @Autowired BuyTicketService (MEMBERRepository M){
        this.M =M;
    }

    public void BuyTicket(int mno,String password,String Ticket){
        MEMBER m =M.findByMnoAndPassword(mno,password);
        m.updateParkingTicket(Ticket);
        M.save(m); //업데이트 기능도 동시에 수행한다. db에 존재한다면
    }



}

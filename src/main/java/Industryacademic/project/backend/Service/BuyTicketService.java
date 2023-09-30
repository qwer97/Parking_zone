package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyTicketService {
    private final STUDENTRepository S;

    @Autowired BuyTicketService (STUDENTRepository S){
        this.S =S;
    }
    public void BuyTicket(int sno,String password,String Ticket){
        STUDENT s =S.findBySnoAndPassword(sno,password);
        s.updateParkingTicket(Ticket);
        S.save(s); //업데이트 기능도 동시에 수행한다. db에 존재한다면
    }



}

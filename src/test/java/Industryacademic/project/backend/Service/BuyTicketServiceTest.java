package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class BuyTicketServiceTest {
    @Autowired
    private BuyTicketService bt;

    @Test
    public void testBuy(){
        int Sno =2019123002;
        String password ="zzgg";
        String pno = "010-2345-3667";
        String newTicket ="4";

        // BuyTicketService의 BuyTicket 메서드 호출
        bt.BuyTicket(Sno, password, newTicket);


    }

}

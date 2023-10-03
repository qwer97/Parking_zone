package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import Industryacademic.project.backend.repository.STUDENTRepository;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BackendApplication.class)
public class DoubleParkingServiceTest {

    @Autowired
    private DoubleParkingService L;

    @Autowired
    @Mock
    private CARRepository C;

    @Autowired
    @Mock
    private PARKING_LOTRepository p;

    @Test
    public void DoubleParking_Entry_Test() {

        // given
        String Cno = "QWERTT";
        String class_info = "금 9~12";
        int Sno =2019125001;
        // when
        L.DoubleParking_Entry(Cno,Sno, class_info);

    }


    @Test
    public void testDoubleParkingCheck(){

        String Cno = "마8888";

        // 테스트 대상 코드의 실행 결과를 print() 메서드를 사용하여 출력합니다.
        //L.DoubleParking_Check(Cno);
        System.out.println(L.DoubleParking_Check(Cno));

    }

}

package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

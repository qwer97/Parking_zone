package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DoubleParkingService { //이중주차 등록과 이중주차 조회 모두 서비스 제공
    
    private final PARKING_LOTRepository P;
    private final CARRepository C;

    @Autowired
    public DoubleParkingService (PARKING_LOTRepository P, CARRepository car){
        this.P =P;
        this.C = car;
    }
    @Transactional
    public void DoubleParking_Entry(String Cno, int Mno,String class_info) {//이중주차 할 때 수업정보 입력

        PARKING_LOT p =P.findByCno(Cno);//자동구현됨
        CAR c = C.findByCno(Cno);

        c.updateClass_info(class_info);
        c.setDouble_parking('Y');
        C.save(c);

    }
    public Map<String, String> DoubleParking_Check(String Cno){ // 이중주차 차주에게 연락하기 위해

        Map<String, String> result = new HashMap<>();

        PARKING_LOT p =P.findByCno(Cno);//자동구현됨
        CAR c = C.findByCno(Cno);

        if(p!=null){ //주차장 안에 있는 차라면

           result.put("Clas_info",c.getClass_info());
        }
        return result;

    }

    
    
}

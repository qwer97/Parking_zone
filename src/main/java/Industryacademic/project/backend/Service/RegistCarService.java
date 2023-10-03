package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistCarService {
    @Autowired
    private CARRepository C;
    @Autowired
    private STUDENTRepository S;

    public void registerCar(String cno, int sno) {
        STUDENT student = S.findBySno(sno);
        CAR car = new CAR();
        car.setCno(cno);
        car.setS(student);

        C.save(car);
    }

}

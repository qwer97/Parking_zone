package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.Entity.STUDENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CARRepository extends JpaRepository<CAR,String> {
    CAR findByCno(String Cno);

}

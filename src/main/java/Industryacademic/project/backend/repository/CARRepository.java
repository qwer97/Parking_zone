package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.Entity.CAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CARRepository extends JpaRepository<CAR,String> {
    CAR findByCno(String Cno);

}

package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CARRepository extends JpaRepository<CAR,String> {
    CAR findByCno(String Cno);


}

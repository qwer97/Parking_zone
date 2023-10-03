package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.Entity.STUDENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STUDENTRepository extends JpaRepository<STUDENT,Long> {//jpa repository 생성
    STUDENT findBySnoAndPassword(int Sno, String password);
    STUDENT findBySno(int Sno);
}




package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.STUDENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public interface STUDENTRepository extends JpaRepository<STUDENT,Long> {//jpa repository 생성
    STUDENT findBySnoAndPassword(int sno, String password);

}




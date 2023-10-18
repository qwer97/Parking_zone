package Industryacademic.project.backend.repository;

import Industryacademic.project.backend.Entity.PARKING_FEE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PARKING_FEERepository extends JpaRepository<PARKING_FEE,String> {
    PARKING_FEE findByMno(int Mno);
}

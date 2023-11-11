package Industryacademic.project.backend.repository;


import Industryacademic.project.backend.Entity.UsagePrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UsagePredictionRepository extends JpaRepository<UsagePrediction,Long> {
    UsagePrediction findByIdAndDateAndTime(long id, Date date,String time);

}

package Industryacademic.project.backend.repository;


import Industryacademic.project.backend.Entity.UsagePrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsagePredictionRepository extends JpaRepository<UsagePrediction,Integer> {
    UsagePrediction findById(int id); //index를 기반으로 찾는다


    //UsagePrediction findByYearAndMonthAndDayAndTime(int Year, int Month, int Day, int Time);
}

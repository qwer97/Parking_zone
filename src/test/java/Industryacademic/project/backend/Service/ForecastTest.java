package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.UsagePrediction;
import Industryacademic.project.backend.repository.UsagePredictionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = BackendApplication.class)
public class ForecastTest {

    @Autowired
    UsagePredictionRepository UP;

    @Autowired
    ForecastService fc;





    @Test
    public void forecast(){
        int year =2023;
        int month =12;
        int day = 2;
        int time =9;
        String weather ="흐림";

        System.out.println( fc.showForecast(year,month,day,time));
    }


    @Test
    public void qtest(){
        int year =2023;
        int month =12;
        int day =9;

        String result[] = fc.forecastall(year,month,day);

        for(int i=0;i<14;i++){
            System.out.println(result[i]);
        }

    }



    @Test
    public void justtest(){
        // 현재 날짜와 시간 얻기
        Date today = new Date();

        // 현재 날짜와 시간 출력
        System.out.println("Current date and time: " + today);

    }
}

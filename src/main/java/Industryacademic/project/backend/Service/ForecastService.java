package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.Entity.UsagePrediction;
import Industryacademic.project.backend.repository.UsagePredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ForecastService {

    private final UsagePredictionRepository UP;

    @Autowired
    public ForecastService(UsagePredictionRepository UP){
        this.UP=UP;
    }


    @Transactional
    public void showForecast(String time, String weather){//예측량 제공

        UsagePrediction u = new UsagePrediction();

        Date today = new Date(); // 오늘 날짜 -> date.
        //9:30 -> 9~11:59니까 9시의 예측을 들고 와야함
        int hour = Integer.parseInt(time.substring(0, 2));

        // 9, 12, 15, 18, 21시의 예측량을 조회
        int index = 0;

        if (hour >= 9 && hour < 12) {
            index = 0;
        } else if (hour >= 12 && hour < 15) {
            index = 1;
        } else if (hour >= 15 && hour < 18) {
            index = 2;
        } else if (hour >= 18 && hour < 21) {
            index = 3;
        } else if (hour >= 21) {
            index = 4;
        }

        //하나의 날짜에 5개의 행. 11월 12일부터 예측치가 들어가므로 오늘이 time+date 를 통해 몇번째 id인지 계산 필요
        //데이터의 형태가 정확히 전달되면 그걸 기반으로 수식을 맞출예정. 일단은 그냥 id=3 출력하는걸로
        int id =3; //(today.getYear() - 2023) * 365 * 5 + (today.getMonth() - 11) * 24 + index+1;

        u=UP.findById(id);

        if (u != null) {
            System.out.println(u.getPrecipitationAmount());
        } else {
            System.out.println("데이터가 없습니다.");
        }

    }


}

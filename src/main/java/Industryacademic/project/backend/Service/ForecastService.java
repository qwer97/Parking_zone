package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.Entity.UsagePrediction;
import Industryacademic.project.backend.repository.UsagePredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class ForecastService {

    private final UsagePredictionRepository UP;

    @Autowired
    public ForecastService(UsagePredictionRepository UP){
        this.UP=UP;
    }


    @Transactional
    public String showForecast(int year,int month,int day,int time){//예측량 제공

        UsagePrediction u = new UsagePrediction();
        //2023 1월 1일 부터 얼마나 지났는지 파악
        //하루에 13개의 예측치
        // 년도/월/일/시간을 입력함으로써 id가 몇인지 알아내서 findById수행

        LocalDate start = LocalDate.of(2023,1,1);
        LocalDate target =LocalDate.of(year,month,day);

        int daypass = (int)ChronoUnit.DAYS.between(start,target);


        int id =daypass*14;
        int index =0;

        if(time ==9){
            index =0;
        }else if(time==10){
            index =1;
        }else if(time==11){
            index =2;
        }else if(time==12){
            index =3;
        }else if(time==13){
            index =4;
        }else if(time==14){
            index =5;
        }else if(time==15){
            index =6;
        }else if(time==16){
            index =7;
        }else if(time==17){
            index =8;
        }else if(time==18){
            index =9;
        }else if(time==19){
            index =10;
        }else if(time==20){
            index =11;
        }else if(time==21){
            index =12;
        }else if(time==22){
            index =13;
        }

        id +=index ;//몇번째 index?

        u=UP.findById(id);

        if (u != null) {
            if(u.getPrecipitationAmount()==0.0){
                return "원활";
            }else if(u.getPrecipitationAmount()==1.0){
                return "보통";
            }else if(u.getPrecipitationAmount()==2.0){
                return "혼잡";
            }else{
                return "매우 혼잡";
            }

        } else {
            System.out.println("데이터가 없습니다.");
            return null;
        }

    }


}

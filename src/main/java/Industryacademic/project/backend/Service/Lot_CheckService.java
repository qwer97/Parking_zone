package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

//4c686665726b7761383461797a5347 api 인증키
@Service
public class Lot_CheckService {

    private final PARKING_LOTRepository PL;

    private final String API_KEY = "4c686665726b7761383461797a5347";


    private final String API_URL = "http://openapi.seoul.go.kr:8088/" + API_KEY + "/xml/IotVdata003/1/5/마포중앙도서관";
    @Autowired
    public Lot_CheckService(PARKING_LOTRepository PL){
        this.PL=PL;
    }

    public String getStatus(){
        RestTemplate rt = new RestTemplate();
        String url = API_URL;

        ResponseEntity<String>response = rt.getForEntity(url,String.class);

        if(response.getStatusCodeValue()==200){
            String body = response.getBody();
            return body;
        }else{
            System.out.println("실패");
            return null; // 실패 시 null을 반환합니다.
        }
    }



    public float lotcheck(){
        float max =57; //실제 가능한 주차 대수 - 217

        float now =  PL.count(); // 현재 DB 내의 대수를 COUNT

        return now/max*100;

    }
}

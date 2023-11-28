package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public String getStatus(){ // 33%을 기준으로 3개(1층,지상,b1주차장
        RestTemplate rt = new RestTemplate();
        String url = API_URL;

        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        if (response.getStatusCodeValue() == 200) {
            String body = response.getBody();
            double percentage = calculatePercentage(body);

            if(percentage<=33.33){
                return "원활";
            }else if(percentage>33.33 & percentage<=66.66){
                return "보통";
            }else if(percentage>66.66){
                return "혼잡";
            }

            return "확인 x";


        } else {
            System.out.println("실패");
            return null;
        }
    }
    private double calculatePercentage(String xmlResponse) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xmlResponse));
            Document document = builder.parse(inputSource);
            document.getDocumentElement().normalize();

            double totalColumn3 = 0;
            double totalColumn4 = 0;

            for (int i = 0; i < document.getElementsByTagName("row").getLength(); i++) {
                totalColumn3 += Double.parseDouble(document.getElementsByTagName("COLUMN3").item(i).getTextContent());
                totalColumn4 += Double.parseDouble(document.getElementsByTagName("COLUMN4").item(i).getTextContent());
            }
            if (totalColumn3 != 0) {

                double percentage = (totalColumn4 / totalColumn3) * 100;
                return percentage;
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle errors
        }
    }




    public float lotcheck(){
        float max =57; //실제 가능한 주차 대수 - 217

        float now =  PL.count(); // 현재 DB 내의 대수를 COUNT

        return now/max*100;

    }
}

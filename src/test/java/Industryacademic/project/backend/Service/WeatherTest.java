package Industryacademic.project.backend.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTest {
    @Autowired
    private WeatherService ws;

    @Test
    public void testGet(){ // 현재 날짜와 시간에 맞게 설정하면 됨. nx, ny는 서울을 의미하기에 고정.
        String weatherData = ws.getWeatherData("20231126","0900","126","37");
        System.out.println(weatherData);
    }
}

package Industryacademic.project.backend.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherService {
    private static final String WEATHER_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?serviceKey={serviceKey}&numOfRows=60&pageNo=1&dataType=json&base_date={base_date}&base_time={base_time}&nx={nx}&ny={ny}";

    public String getWeatherData(String baseDate, String baseTime, String nx, String ny) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> params = new HashMap<>();
        params.put("serviceKey", "dviZYogjXGkyID81N9u9g68FI01IUenHk6muuYjyWfZrwzeiOy2ARXaYZonAVj%2Fhv%2FdWXp8CNbZ%2F0aQ5cfr6Ag%3D%3D");
        params.put("base_date","20231125");
        params.put("base_time","0900");
        params.put("nx",String.valueOf(126));
        params.put("ny",String.valueOf(37));


        String result = restTemplate.getForObject(WEATHER_URL, String.class, params);
        return result;
        /*
        JSONObject jsonObject = new JSONObject(result);
        JSONObject response = jsonObject.getJSONObject("response");
        JSONObject body = response.getJSONObject("body");
        JSONArray items = body.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            if (item.getString("category").equals("SKY")) {
                String fcstValue = item.getString("fcstValue");

                // Return only clear, rain, or cloudy weather conditions
                if (fcstValue.equals("맑음") || fcstValue.equals("비") || fcstValue.equals("흐림")) {
                    return fcstValue;
                }
            }
        }

        return null;

         */

    }
}

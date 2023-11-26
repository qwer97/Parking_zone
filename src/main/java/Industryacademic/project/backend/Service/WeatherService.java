package Industryacademic.project.backend.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherService {
    private static final String WEATHER_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?serviceKey={serviceKey}&numOfRows=60&pageNo=1&dataType=json&base_date={base_date}&base_time={base_time}&nx={nx}&ny={ny}";

    public String getWeatherData(String baseDate, String baseTime, String nx, String ny) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("serviceKey", "dviZYogjXGkyID81N9u9g68FI01IUenHk6muuYjyWfZrwzeiOy2ARXaYZonAVj/hv/dWXp8CNbZ/0aQ5cfr6Ag==");
        params.put("base_date", "20231126");
        params.put("base_time", "2100"); // 기본값으로 "0930" 설정

        try {
            // baseTime을 정수로 파싱하여 시간을 얻음
            int parsedBaseTime = Integer.parseInt(baseTime);

            // 가장 비슷한 시간대의 정보를 가져오도록 base_time을 설정
            if (parsedBaseTime >= 30) {
                params.put("base_time", String.format("%02d30", (parsedBaseTime / 100)));
            } else {
                params.put("base_time", String.format("%02d00", (parsedBaseTime / 100 - 1)));
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "날씨 정보를 가져오는 중 오류가 발생했습니다. (base_time 파싱 오류)";
        }

        params.put("nx", String.valueOf(126));
        params.put("ny", String.valueOf(37));

        String result = restTemplate.getForObject(WEATHER_URL, String.class, params);

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(result);

            JSONObject response = (JSONObject) jsonObject.get("response");
            JSONObject body = (JSONObject) response.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray itemList = (JSONArray) items.get("item");

            for (int i = 0; i < itemList.size(); i++) {
                JSONObject item = (JSONObject) itemList.get(i);
                if ("SKY".equals(item.get("category"))) {
                    String fcstValue = (String) item.get("fcstValue");

                    // "맑음", "비", "흐림" 중 하나일 때만 반환
                    if ("1".equals(fcstValue)) {
                        return "맑음";
                    } else if ("2".equals(fcstValue)) {
                        return "비";
                    } else if ("3".equals(fcstValue) || "4".equals(fcstValue)) {
                        return "흐림";
                    } else{
                        return "맑음";
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "날씨 정보를 가져오는 중 오류가 발생했습니다. (파싱 오류)";
        } catch (Exception e) {
            e.printStackTrace();
            return "날씨 정보를 가져오는 중 오류가 발생했습니다. (일반 오류)";
        }

        return "날씨 정보를 가져오는 중 오류가 발생했습니다. (해당 시간의 날씨 정보 없음)";
    }
}

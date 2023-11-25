package Industryacademic.project.backend.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherScheduler {
    /*
    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void getWeatherDataEveryHour() {
        String baseDate = getCurrentDate();
        String baseTime = getCurrentTime();
        String nx = "60";  // 예시 좌표
        String ny = "127"; // 예시 좌표
        String weatherData = weatherService.getWeatherData(baseDate, baseTime, nx, ny);
        // 여기서 weatherData를 원하는 대로 처리합니다.
    }

    private String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    private String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HHmm"));
    }

     */
}

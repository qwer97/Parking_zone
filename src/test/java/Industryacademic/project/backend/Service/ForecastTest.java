package Industryacademic.project.backend.Service;


import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.UsagePrediction;
import Industryacademic.project.backend.repository.UsagePredictionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendApplication.class)
public class ForecastTest {

    @Autowired
    UsagePredictionRepository UP;

    @Autowired
    ForecastService fc;




    @Test
    public void forecast(){
        String time ="15:12";
        String weather ="흐림";

        fc.showForecast(time,weather);
    }
}

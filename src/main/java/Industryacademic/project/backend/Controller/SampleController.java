package Industryacademic.project.backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    public SampleController(){
        System.out.println("Parking_Zone");
    }


    @RequestMapping() //mapping 에 아무것도 입력하지 않으면 바로 출력되네
    public String method(){
        return "돌아온 탕아";
    }
}

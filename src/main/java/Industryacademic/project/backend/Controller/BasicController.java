package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Entity.UsagePrediction;
import Industryacademic.project.backend.Service.*;
import Industryacademic.project.backend.Service.RegistMEMBERService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {
    private final RegistMEMBERService rm;
    private final RegistCarService rc;
    private final LoginService ls;

    private final ForecastService fs;

    @Autowired
    public BasicController(RegistMEMBERService rm, RegistCarService rc, LoginService ls,ForecastService fs){
        this.rm =rm;
        this.rc =rc;
        this.ls =ls;
        this.fs=fs;

    }

    @PostMapping("/api/forecast")
    public ModelAndView forecast(@RequestParam("time") String time, @RequestParam("weather") String weather) {

        UsagePrediction usagePrediction=fs.showForecast(time, weather);

        ModelAndView modelAndView = new ModelAndView("forecast");
        modelAndView.addObject("message", "예측량을 제공하겠습니다.");

        modelAndView.addObject("usagePrediction", usagePrediction); // 실제 열과 이름 맞춰야 함


        return modelAndView;
    }


    // 학생 등록 양식을 위한 매핑
    @PostMapping("/api/register/member")
    public ModelAndView registerMember(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("pno") String pno) {

        rm.MEMBERRegistration(id, password, pno); // 학생 등록 로직을 호출

        ModelAndView modelAndView = new ModelAndView("regist"); // View 이름을 설정합니다.
        modelAndView.addObject("message", "등록되었습니다."); // 메시지를 모델에 추가합니다.
        return modelAndView; // 메인 페이지로 리디렉션하지 않고 메시지와 함께 그대로 표시됩니다.
    }

    // 자동차 등록 양식을 위한 매핑
    @PostMapping("/api/register/car")
    public ModelAndView registerCar(@RequestParam("cno") String cno, @RequestParam("id") String id) {

        rc.registerCar(cno, id); // 자동차 등록 로직을 호출

        ModelAndView modelAndView = new ModelAndView("regist"); // View 이름을 설정합니다.
        modelAndView.addObject("message", "등록되었습니다."); // 메시지를 모델에 추가합니다.
        return modelAndView; // 메인 페이지로 리디렉션하지 않고 메시지와 함께 그대로 표시됩니다.
    }

    // 로그인 양식을 위한 매핑
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password,HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(); // View 이름을 설정하지 않습니다.

        if (ls.login(id, password)) {
            session.setAttribute("id",id); // 세션에 mno 저장
            modelAndView.addObject("message", "인증되었습니다."); // 인증 성공 메시지를 모델에 추가합니다.
            modelAndView.setViewName("choice"); // 로그인 성공 시 대시보드 페이지로 이동

        } else {
            modelAndView.addObject("error", "로그인 실패"); // 로그인 실패 메시지를 모델에 추가합니다.
            modelAndView.setViewName("home"); // 로그인 실패 시 로그인 페이지로 이동
        }

        return modelAndView;
    }



}

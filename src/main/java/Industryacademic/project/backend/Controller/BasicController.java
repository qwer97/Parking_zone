package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Service.LoginService;
import Industryacademic.project.backend.Service.RegistCarService;
import Industryacademic.project.backend.Service.RegistMEMBERService;
import Industryacademic.project.backend.Service.RegistMEMBERService;
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


    @Autowired
    public BasicController(RegistMEMBERService rm, RegistCarService rc, LoginService ls){
        this.rm =rm;
        this.rc =rc;
        this.ls =ls;

    }
    // 학생 등록 양식을 위한 매핑
    @PostMapping("/api/register/member")
    public ModelAndView registerMember(@RequestParam("mno") int mno, @RequestParam("password") String password, @RequestParam("pno") String pno) {
        rm.MEMBERRegistration(mno, password, pno); // 학생 등록 로직을 호출

        ModelAndView modelAndView = new ModelAndView("regist"); // View 이름을 설정합니다.
        modelAndView.addObject("message", "등록되었습니다."); // 메시지를 모델에 추가합니다.
        return modelAndView; // 메인 페이지로 리디렉션하지 않고 메시지와 함께 그대로 표시됩니다.
    }
    // 자동차 등록 양식을 위한 매핑
    @PostMapping("/api/register/car")
    public ModelAndView registerCar(@RequestParam("cno") String cno, @RequestParam("mno") int mno) {
        rc.registerCar(cno, mno); // 자동차 등록 로직을 호출

        ModelAndView modelAndView = new ModelAndView("regist"); // View 이름을 설정합니다.
        modelAndView.addObject("message", "등록되었습니다."); // 메시지를 모델에 추가합니다.
        return modelAndView; // 메인 페이지로 리디렉션하지 않고 메시지와 함께 그대로 표시됩니다.
    }

    // 로그인 양식을 위한 매핑
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("mno") int mno, @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView(); // View 이름을 설정하지 않습니다.

        if (ls.login(mno, password)) {
            modelAndView.addObject("message", "인증되었습니다."); // 인증 성공 메시지를 모델에 추가합니다.
            modelAndView.setViewName("choice"); // 로그인 성공 시 대시보드 페이지로 이동
        } else {
            modelAndView.addObject("error", "로그인 실패"); // 로그인 실패 메시지를 모델에 추가합니다.
            modelAndView.setViewName("home"); // 로그인 실패 시 로그인 페이지로 이동
        }

        return modelAndView;
    }



}

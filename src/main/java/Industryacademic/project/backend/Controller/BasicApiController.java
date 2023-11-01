package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Service.LoginService;
import Industryacademic.project.backend.Service.RegistCarService;
import Industryacademic.project.backend.Service.RegistMEMBERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
/*
@Controller
@RequestMapping("/api") // API를 위한 기본 경로 정의
public class BasicApiController {
    private final RegistMEMBERService rm;
    private final RegistCarService rc;
    private final LoginService ls;

    @Autowired
    public BasicApiController(RegistMEMBERService rm, RegistCarService rc, LoginService ls) {
        this.rm = rm;
        this.rc = rc;
        this.ls = ls;
    }



    // 학생 등록 양식을 위한 매핑
    @PostMapping("/register/member")
    public ResponseEntity<String> registerMember(@RequestParam("mno") int mno, @RequestParam("password") String password, @RequestParam("pno") String pno) {
        rm.MEMBERRegistration(mno, password, pno);

        return ResponseEntity.ok("등록되었습니다.");
    }

    // 자동차 등록 양식을 위한 매핑
    @PostMapping("/register/car")
    public ResponseEntity<String> registerCar(@RequestParam("cno") String cno, @RequestParam("mno") int mno) {
        rc.registerCar(cno, mno);

        return ResponseEntity.ok("등록되었습니다.");
    }

    // 로그인 양식을 위한 매핑
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("mno") int mno, @RequestParam("password") String password) {
        if (ls.login(mno, password)) {
            return ResponseEntity.ok("인증되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
}
*/
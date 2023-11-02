package Industryacademic.project.backend.Controller;
/*
import Industryacademic.project.backend.Service.LoginService;
import Industryacademic.project.backend.Service.RegistCarService;
import Industryacademic.project.backend.Service.RegistMEMBERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
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
    public ResponseEntity<Map<String, String>> registerMember(@RequestParam("mno") int mno, @RequestParam("password") String password, @RequestParam("pno") String pno) {
        rm.MEMBERRegistration(mno, password, pno);

        Map<String, String> response = new HashMap<>();
        response.put("message", "등록되었습니다.");

        return ResponseEntity.ok(response);
    }

    // 자동차 등록 양식을 위한 매핑
    @PostMapping("/register/car")
    public ResponseEntity<Map<String, String>> registerCar(@RequestParam("cno") String cno, @RequestParam("mno") int mno) {
        rc.registerCar(cno, mno);

        Map<String, String> response = new HashMap<>();
        response.put("message", "등록되었습니다.");

        return ResponseEntity.ok(response);
    }

    // 로그인 양식을 위한 매핑
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam("mno") int mno, @RequestParam("password") String password) {
        if (ls.login(mno, password)) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "인증되었습니다.");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "로그인 실패");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
*/
package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.Service.FeeCheckService;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.MEMBERRepository;
import Industryacademic.project.backend.repository.PARKING_FEERepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FunctionController {
    @Autowired
    private final FeeCheckService fs;


    @Autowired
    public FunctionController(FeeCheckService fs){
        this.fs =fs;
    }
    @Autowired
    private CARRepository C;
    @Autowired
    private MEMBERRepository M;
    @Autowired
    private PARKING_FEERepository PF;

    @GetMapping("/function/1")
    public ModelAndView checkInformation(HttpSession session){
        int mno = (int) session.getAttribute("mno"); // 세션에서 mno 가져오기

        ModelAndView modelAndView = new ModelAndView("result1"); // 결과를 표시할 뷰 페이지
        MEMBER member = M.findByMno(mno);


        modelAndView.addObject("member", member);

        return modelAndView;
    }

    @GetMapping("/function/2")
    public ModelAndView checkParkingFee(@PathVariable int mno , @PathVariable String cno){

        MEMBER m = M.findByMno(mno);
        CAR c =new CAR();
        c.setM(m);
        /*
        추가 구현
         */
        ModelAndView modelAndView = new ModelAndView("result2"); // 결과를 표시할 뷰 페이지
        modelAndView.addObject("message", "주차 요금이 체크되었습니다.");
        return modelAndView;
    }

/*
    @GetMapping("/logout")
    public ModelAndView logout(){

    }
*/
}

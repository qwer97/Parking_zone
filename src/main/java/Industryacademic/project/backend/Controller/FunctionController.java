package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.Entity.PARKING_FEE;
import Industryacademic.project.backend.Service.BoardService;
import Industryacademic.project.backend.Service.BuyTicketService;
import Industryacademic.project.backend.Service.FeeCheckService;
import Industryacademic.project.backend.Service.Lot_CheckService;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.MEMBERRepository;
import Industryacademic.project.backend.repository.PARKING_FEERepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import jakarta.servlet.http.HttpServletRequest;
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
    private final BuyTicketService bt; //buy ticket


    @Autowired
    private final Lot_CheckService lc;

    @Autowired
    private final BoardService bs;

    @Autowired
    public FunctionController(FeeCheckService fs, BuyTicketService bt,Lot_CheckService lc,BoardService bs){
        this.fs =fs;
        this.bt =bt;
        this.lc=lc;
        this.bs =bs;
    }

    @Autowired
    private CARRepository C;
    @Autowired
    private MEMBERRepository M;
    @Autowired
    private PARKING_FEERepository PF;

    @Autowired
    private PARKING_LOTRepository PL;

    @GetMapping("/function/1") //해결
    public ModelAndView checkInformation(HttpSession session){
        int mno = (int) session.getAttribute("mno"); // 세션에서 mno 가져오기

        ModelAndView modelAndView = new ModelAndView("result1"); // 결과를 표시할 뷰 페이지
        MEMBER member = M.findByMno(mno); // 멤버 정보 가져오기
        CAR c = C.findByMemberMno(mno); // CAR 정보 가져오기

        modelAndView.addObject("member", member);
        modelAndView.addObject("car", c.getCno());

        return modelAndView;
    }


    @GetMapping("/function/2")
    public ModelAndView checkParkingFee(HttpSession session){
        int mno = (int) session.getAttribute("mno");

        ModelAndView modelAndView = new ModelAndView("result2"); // 결과를 표시할 뷰 페이지

        MEMBER m = M.findByMno(mno);

        CAR c =C.findByMemberMno(mno);

        PARKING_FEE pf = PF.findByMno(mno);

        int parkingfee= fs.FeeCheck(mno,c.getCno());

        modelAndView.addObject("message", parkingfee); // 결과를 메시지로 전달

        return modelAndView;
    }


    @GetMapping("/function/3")
    public ModelAndView Buyticket(HttpSession session, HttpServletRequest request){
        int mno = (int) session.getAttribute("mno");
        MEMBER member = M.findByMno(mno);

        // 3에서의 작업을 수행한다.
        String selectedTicketType = request.getParameter("selectedTicketType");
        bt.BuyTicket(mno,member.getPassword(),selectedTicketType);

        ModelAndView modelAndView = new ModelAndView("result3");
        modelAndView.addObject("member", member);
        modelAndView.addObject("ticketType", selectedTicketType);

        return modelAndView;
    }

    @GetMapping("/function/4")
    public ModelAndView nowlot(HttpSession session){

        float now =lc.lotcheck();

        ModelAndView modelAndView = new ModelAndView("result4"); // 결과를 표시할 뷰 페이지
        String nowStr = String.format("%.2f", now); // now를 String 타입으로 변환

        modelAndView.addObject("now", nowStr); // 모델에 "now" 값을 추가
        return modelAndView;
    }
    @GetMapping("/function/5")
    public ModelAndView Board(HttpSession session,@RequestParam String con,@RequestParam String ti){ // 게시판 기능
        int mno =(int) session.getAttribute("mno");  // 세션에서 mno 받아주고
        MEMBER member = M.findByMno(mno);


        ModelAndView modelAndView = new ModelAndView("result5");




        return modelAndView;
    }

    @GetMapping("/logout") //해결
    public ModelAndView logout(){
        ModelAndView modelAndView= new ModelAndView("home"); //초기화면으로 돌아감
        return modelAndView;
    }

}

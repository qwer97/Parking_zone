package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Entity.BoardPost;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/function/1") //로그인 해야 사용가능
    public ModelAndView checkInformation(HttpSession session){
        String id = (String) session.getAttribute("id"); // 세션에서 id 가져오기

        ModelAndView modelAndView = new ModelAndView("result1"); // 결과를 표시할 뷰 페이지
        MEMBER member = M.findById(id); // 멤버 정보 가져오기
        CAR c = C.findByMemberMno(member.getMno()); // CAR 정보 가져오기

        modelAndView.addObject("member", member);
        modelAndView.addObject("car", c.getCno());

        return modelAndView;
    }


    @GetMapping("/function/2")//로그인 해야 사용가능
    public ModelAndView checkParkingFee(HttpSession session){
        String id = (String) session.getAttribute("id");

        ModelAndView modelAndView = new ModelAndView("result2"); // 결과를 표시할 뷰 페이지

        MEMBER member = M.findById(id);

        CAR c =C.findByMemberMno(member.getMno());

        PARKING_FEE pf = PF.findByMno(member.getMno());

        int parkingfee= fs.FeeCheck(member.getMno(),c.getCno());

        modelAndView.addObject("message", parkingfee); // 결과를 메시지로 전달

        return modelAndView;
    }

    @GetMapping("/function/3")
    public ModelAndView Buyticket(HttpSession session, HttpServletRequest request){
        String id = (String) session.getAttribute("id");

        MEMBER member = M.findById(id);

        // 3에서의 작업을 수행한다.
        String selectedTicketType = request.getParameter("selectedTicketType");
        bt.BuyTicket(member.getMno(), member.getPassword(),selectedTicketType);

        ModelAndView modelAndView = new ModelAndView("result3");
        modelAndView.addObject("member", member);
        modelAndView.addObject("ticketType", selectedTicketType);

        return modelAndView;
    }

    @GetMapping("/function/5")
    public ModelAndView displayBoard(HttpSession session) {
        String id = (String) session.getAttribute("id");
        MEMBER member = M.findById(id);

        ModelAndView modelAndView = new ModelAndView("Post");
        return modelAndView;
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<BoardPost>> getAllPosts(HttpSession session) {
        List<BoardPost> posts = bs.Viewall();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/api/posts")
    public ResponseEntity<Void> createPost(@RequestBody BoardPost post,HttpSession session) {
        // Assuming you have a method to save the post in your BoardService
        String id = (String) session.getAttribute("id");

        MEMBER member = M.findById(id);

        bs.RegistPost(member.getMno(),post.getTitle(),post.getContent());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /*
    @PostMapping("/api/posts")
    public ResponseEntity<Void> deletePost(@RequestParam int postId, HttpSession session) {
        String id = (String) session.getAttribute("id");

        MEMBER member = M.findById(id);
        try {
            bs.DeletePost(postId, member.getMno());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // 예외 발생 시 적절한 응답 처리
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

     */


    @GetMapping("/logout") //해결
    public ModelAndView logout(){
        ModelAndView modelAndView= new ModelAndView("home"); //초기화면으로 돌아감
        return modelAndView;
    }

}

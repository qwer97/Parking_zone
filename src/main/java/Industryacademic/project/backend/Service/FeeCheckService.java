package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.CAR;
import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.Entity.PARKING_FEE;
import Industryacademic.project.backend.Entity.PARKING_LOT;
import Industryacademic.project.backend.repository.CARRepository;
import Industryacademic.project.backend.repository.MEMBERRepository;
import Industryacademic.project.backend.repository.PARKING_FEERepository;
import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class FeeCheckService {
    PARKING_FEERepository PF;

    CARRepository C;

    PARKING_LOTRepository PL;

    MEMBERRepository M;

    public FeeCheckService(PARKING_FEERepository PF, CARRepository C,PARKING_LOTRepository PL,MEMBERRepository M){
        this.PF=PF;
        this.C=C;
        this.PL=PL;
        this.M =M;
    }

    public int FeeCheck(int mno,String cno){

        CAR c =C.findByCno(cno);
        PARKING_FEE p = new PARKING_FEE();
        p.setC(c);
        p.setMno(mno); //parkingfee인식

        PARKING_LOT pl = PL.findByCno(cno);

        MEMBER m = M.findByMno(mno);

        // 주차 시작 시간 가져오기
        LocalDateTime entryTime = pl.getEntryTime().toLocalDateTime();

        // 현재 시간 가져오기
        LocalDateTime currentTime = LocalDateTime.now();

        // 주차 시간 계산
        long parkingTime = Duration.between(entryTime, currentTime).toMinutes();

        // 주차 요금 계산 - 실제 주차장에서 1분에 40분
        int parkingFee = (int) (parkingTime * 40);

        if(m.getParkingTicket()==null){
            p.setFee(parkingFee);
        }
        else{
            p.setFee(0);
        }

        PF.save(p);

        return p.getFee();

    }
}



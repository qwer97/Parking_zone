package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.repository.PARKING_LOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotClearService {

    private final PARKING_LOTRepository P;

    @Autowired
    public ParkingLotClearService(PARKING_LOTRepository P){
        this.P =P;
    }

    public void deleteAllEmployees() {
        P.deleteAll();
    }


}

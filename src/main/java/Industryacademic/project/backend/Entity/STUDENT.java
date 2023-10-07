package Industryacademic.project.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="STUDENT")
public class STUDENT {
    @Id
    @Getter
    @Setter
    private int sno;  // primary key 선언

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String pno;


    @Getter
    @Setter
    private String parkingTicket;
    public void updateParkingTicket(String newTicketType) {
        this.parkingTicket = newTicketType;
    }
}
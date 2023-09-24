package Industryacademic.project.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENT")
public class STUDENT {
    @Id
    private int SNO;  // primary key 선언
    private String Password;
    private String Pno;
    private String Parking_ticket;


}
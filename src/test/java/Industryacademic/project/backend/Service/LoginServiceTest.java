package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Controller.BackendApplication;
import Industryacademic.project.backend.Entity.STUDENT;
import Industryacademic.project.backend.repository.STUDENTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes =BackendApplication.class)
public class LoginServiceTest {
    @Autowired
    private LoginService L;

    @MockBean
    private STUDENTRepository s;

    @Test
    public void testLogin(){
        int Sno = 2017125037;
        String password ="2222";
        String Pno ="010-4019-3269";
        STUDENT ST = new STUDENT();
        ST.setSno(Sno);
        ST.setPassword(password);
        ST.setPno(Pno);

        // When
        when(s.findBySnoAndPassword(Sno, password)).thenReturn(ST);

        // Then
        assertTrue(L.login(Sno, password));
    }
}

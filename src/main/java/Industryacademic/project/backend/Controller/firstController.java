package Industryacademic.project.backend.Controller;

import Industryacademic.project.backend.Service.firstService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class firstController {
    private final firstService first;

    @GetMapping()
    public String firstController(){
        return first.getFirstData();
    }
}

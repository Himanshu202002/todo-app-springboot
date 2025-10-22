package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckk {

    @GetMapping("abc")
    public String HealthCheckk(){
        return "ok";
    }
}

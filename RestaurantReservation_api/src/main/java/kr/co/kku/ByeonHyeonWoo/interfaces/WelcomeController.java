package kr.co.kku.ByeonHyeonWoo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String hell0(){
        return "Hello, world!!!!";
    }
}

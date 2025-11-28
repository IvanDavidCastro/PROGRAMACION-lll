package com.code.SpringBoot.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeContrl {
    
     @GetMapping
    public String welcome(){
        return "welcome";
    }

     @GetMapping("/cursos")
    public String cursos(){
        return "cursos";
    }
 
}

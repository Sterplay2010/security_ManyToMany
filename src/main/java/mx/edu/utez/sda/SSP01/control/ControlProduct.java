package mx.edu.utez.sda.SSP01.control;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ControlProduct {

    @Secured("ROLE_USER")
    @GetMapping("/find-all")
    public String findAll(){
        return "product/find-all";
    }

    @Secured("ROLE_USER")
    @GetMapping("/create")
    public String create(){
        return "product/create";
    }
}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Service;

@Controller
public class Calculate {
    @Autowired
    private Service service;
    @PostMapping({"/calculate"})
    public String calculate(@RequestParam String doLa, Model model){

        model.addAttribute("vnd",service.calculate(Integer.parseInt(doLa)));
        return "vnd";
    }

}

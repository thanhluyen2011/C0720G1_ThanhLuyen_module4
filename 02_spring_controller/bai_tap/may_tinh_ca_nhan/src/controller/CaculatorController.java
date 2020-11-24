package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CaculatorService;

@Controller
public class CaculatorController {

    @Autowired
    private CaculatorService service;

    @RequestMapping("/calculate")
    public String calculate(ModelMap model, @RequestParam(name = "number1", defaultValue = "0") double number1, @RequestParam(name = "number2", defaultValue = "0") double number2, @RequestParam(name = "calculation", defaultValue = "") String calcul) {
        double result = service.caculate(number1,number2,calcul);
        model.addAttribute("result",result);
        return "index";
    }
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

}

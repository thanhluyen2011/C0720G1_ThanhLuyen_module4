package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sum {
    @GetMapping({"/sum"})
    public String sum2Number(@RequestParam String num1,
                             @RequestParam String num2,
                             Model model) {
        int num3 = Integer.parseInt(num1);
        int num4 = Integer.parseInt(num2);
        int result = num3 + num4;
        model.addAttribute("result",result);

//        model.addAttribute("resultNumber",
//                sumService.sum(Integer.parseInt(number1), Integer.parseInt(b)));

        return "result";
    }
}

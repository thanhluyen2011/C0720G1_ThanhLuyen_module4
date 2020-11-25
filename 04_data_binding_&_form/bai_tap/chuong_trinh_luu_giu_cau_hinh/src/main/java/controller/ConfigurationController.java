package controller;

import model.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ConfigurationController {
    @GetMapping("")
    public String goCreateStudent(Model model) {
        model.addAttribute("ConfigurationObject", new Configuration());
        return "index";
    }
    @GetMapping("/list")
    public String finAll(@ModelAttribute Configuration configuration,Model model){
        model.addAttribute("language",configuration.getLanguage());
        model.addAttribute("pageSize",configuration.getPageSize());
        model.addAttribute("spamFilter",configuration.isSpamFilter());
        model.addAttribute("signature",configuration.getSignature());
        return "list";
    }
}

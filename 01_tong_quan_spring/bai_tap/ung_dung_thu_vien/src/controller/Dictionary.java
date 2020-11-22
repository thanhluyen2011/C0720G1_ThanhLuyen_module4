package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

@Controller
public class Dictionary {
    @Autowired
    private DictionaryService service;
    @PostMapping({"/dictionary"})
    public String search(@RequestParam String tu, Model model){
        model.addAttribute("data",service.dictionary(tu));
        return "hienthi";
    }

}

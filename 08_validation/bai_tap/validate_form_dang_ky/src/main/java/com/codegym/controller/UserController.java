package com.codegym.controller;

import com.codegym.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @GetMapping("")
    public ModelAndView getInput(){
        return new ModelAndView("input","userModel",new UserModel());
    }
    @PostMapping("/result")
    public String create(@Validated @ModelAttribute UserModel userModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "input";
        }else {
            return "" +
                    "";
        }
    }
}

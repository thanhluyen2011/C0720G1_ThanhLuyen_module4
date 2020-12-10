package com.codegym.controllers;

import com.codegym.entity.AppUser;
import com.codegym.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = "userLogin")
@RequestMapping({"", "/login"})
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping({"", "/login"})
    public String goLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("appRoleList", this.userDetailsService.allAppRole());
        model.addAttribute("newUser", new AppUser());
        return "register";
    }

    @PostMapping("/registerNew")
    public String registerNew(@ModelAttribute AppUser appUser, @RequestParam Long[] appRole, RedirectAttributes redirectAttributes) {
        boolean check = true;
        List<AppUser> appUserList = this.userDetailsService.allAppUser();
        for (AppUser appUserExist : appUserList) {
            if (appUser.getUserName().equals(appUserExist.getUserName())) {
                check = false;
                break;
            }
        }
        if (check) {
            appUser.setEncrytedPassword(this.bCryptPasswordEncoder.encode(appUser.getEncrytedPassword()));
            appUser.setUserId((long) (Math.random()*1000));
            this.userDetailsService.saveNewUser(appUser);
            for (Long element : appRole) {
                this.userDetailsService.saveUserRole(appUser, element);
            }
            redirectAttributes.addFlashAttribute("message", "Register Complete !");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("message", "User Name is existed !");
            return "redirect:/register";
        }
    }
}

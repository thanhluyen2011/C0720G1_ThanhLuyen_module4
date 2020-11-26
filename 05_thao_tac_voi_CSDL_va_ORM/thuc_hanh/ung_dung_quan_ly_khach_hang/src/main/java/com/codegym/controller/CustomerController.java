package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping({"/customer","/"})
public class CustomerController{
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String goListStudent(Model model) {

        model.addAttribute("listStudent", customerService.findAll());

        return "list_student";
    }

    @GetMapping("/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("studentDetail", customerService.findById(id));
        return "detail_student";
    }

    @GetMapping("/detail/{idStudent}")
    public String goDetailStudentPathVariable(@PathVariable(value = "idStudent") Integer id, Model model) {
        model.addAttribute("studentDetail", customerService.findById(id));
        return "detail_student";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("student", new Customer());

        return "create_student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Customer student, RedirectAttributes redirectAttributes) {

        this.customerService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student OK!");

        return "redirect:/student";
    }
}

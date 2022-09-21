package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public ModelAndView showIndex(){
        return new ModelAndView("/product/list");
    }
    @GetMapping("/login")
    public ModelAndView getLogin(){
        return new ModelAndView("product/login");
    }
    @GetMapping("/register")
    public ModelAndView getRegister(){
        return new ModelAndView("product/register");
    }
}

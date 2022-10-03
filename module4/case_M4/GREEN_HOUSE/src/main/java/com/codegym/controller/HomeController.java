package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping
@Controller
public class HomeController {

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView showSignUpPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/register");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/list");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }
}

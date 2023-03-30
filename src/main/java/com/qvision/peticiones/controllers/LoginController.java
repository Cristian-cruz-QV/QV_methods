package com.qvision.peticiones.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }

    @GetMapping("/expired")
    public String expired() {
        return "expired";
    }

    @GetMapping("/mensaje")
    public String mensaje() {

        return "mensaje";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        // perform audit action
        return "/";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        // perform audit action
        return "login";
    }

}

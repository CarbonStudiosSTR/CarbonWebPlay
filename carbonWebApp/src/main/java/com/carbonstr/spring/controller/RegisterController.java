package com.carbonstr.spring.controller;

import com.carbonstr.spring.model.Account;
import com.carbonstr.spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    private RegisterService registerService;

    @Autowired(required = true)
    @Qualifier(value = "registerService")
    public void setPersonService(RegisterService ps) {
        this.registerService = ps;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    @RequestMapping(value = "/register/create", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("account") Account a) {
        this.registerService.registerAccount(a);
        return "redirect:/sign_in";
    }

}

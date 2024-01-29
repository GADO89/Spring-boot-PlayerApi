package com.spring.playerapi.controller;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class TestController {

    @GetMapping("/profile")
    public String test(Model model) {
        model.addAttribute("name","Eslam Khder");
        return "home";
    }


}

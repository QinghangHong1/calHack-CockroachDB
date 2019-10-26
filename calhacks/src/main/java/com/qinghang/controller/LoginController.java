package com.qinghang.controller;


import com.qinghang.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    BasicDAO dao;
    @PostMapping("/login")
    public String loginController() {



        return "Hello";
    }
}

package com.qinghang.controller;


import com.qinghang.dao.BasicDAO;
import com.qinghang.dao.LoginDao;
import com.qinghang.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginDao dao;
    @PostMapping("/login")
    public Response loginController(@NotBlank(message = "{required}") String username, @NotBlank(message = "{required}") String password, HttpServletRequest request)  throws Exception{
        return dao.login(username, password);
    }

}

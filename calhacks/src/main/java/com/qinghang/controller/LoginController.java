package com.qinghang.controller;


import com.qinghang.Exceptions.DuplicateUserException;
import com.qinghang.Exceptions.UnauthorizedException;
import com.qinghang.dao.LoginDao;
import com.qinghang.dao.RegisterDao;
import com.qinghang.domain.Response;
import com.qinghang.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

@RestController
public class LoginController {
    @Autowired
    LoginDao dao;
    @PostMapping("/login")
    public Response loginController(@NotBlank(message = "required") String username, @NotBlank(message = "required") String password, HttpServletRequest request)  throws UnauthorizedException{
        return dao.login(username, password);

    }
    @Autowired
    RegisterDao registerDao;
    @PostMapping("/register")
    public Response registerController(@NotBlank(message = "required") String username, @NotBlank(message = "required") String password, HttpServletRequest request) throws  DuplicateUserException {

        return registerDao.registerUser(username, password);

    }

}

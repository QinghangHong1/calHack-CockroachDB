package com.qinghang.dao;

import com.qinghang.domain.Response;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
    public Response login(String username, String password){
        return new Response();
    }

    public String getPassword(String username) {

    }

}

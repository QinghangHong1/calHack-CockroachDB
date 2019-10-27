package com.qinghang.dao;

import com.qinghang.Exceptions.DuplicateUserException;
import com.qinghang.domain.Response;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDao {
    public Response registerUser(String username, String password) throws DuplicateUserException {
        return null;
    }
}

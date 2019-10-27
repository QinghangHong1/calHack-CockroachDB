package com.qinghang.dao;

import com.qinghang.Exceptions.UnauthorizedException;
import com.qinghang.domain.Response;
import com.qinghang.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginDao {
    @Autowired
    private DataSource ds;
    public Response login(String username, String password) throws UnauthorizedException, SQLException {
        password = MD5Util.encrypt(username, password);
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM my_doctor.user WHERE username=? AND password=?");
        preparedStatement.setString(0,username);
        preparedStatement.setString(1, password);

        preparedStatement.execute();
        ResultSet rs = preparedStatement.getResultSet();
        if(rs.next()){
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("id", rs.getInt("id"));
            return new Response().data(map);
        }


    }
    public void createAccount() {
        basicDAO.runSQL("CREATE TABLE IF NOT EXISTS accounts (id INT PRIMARY KEY , username VARCHAR(50) PRIMARY KEY, password VARCHAR(128))");
    };

    /**
     * Update accounts by passing in a Map of (ID, Balance) pairs.
     *
     * @param accounts (Map)
     * @return The number of updated accounts (int)
     */
    public void () {

        basicDAO.runSQL("SELECT * accounts WHERE (username, password) VALUE (?, ?)", args);

    }

}

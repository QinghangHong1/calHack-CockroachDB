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

@Repository
public class RecipeDao{
    @Autowired
    private DataSource dataSource;

    public Response getRecipe(String disease) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement
                = connection.prepareStatement("SELECT FROM my_doctor.recipe WHERE disease=?");
        preparedStatement.setString(1, disease);

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        HashMap<String, String> hashMap = new HashMap<String, String>();
        ;
        if (resultSet.next())
            hashMap.put(resultSet.getString("dish")
                    , resultSet.getString("recipe"));

        return new Response().data(hashMap);
    }


    }

}

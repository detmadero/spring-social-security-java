package com.mcnc.spring.social.security.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mcnc.spring.social.security.model.MyUserAccount;

public class MyUserAccountMapper implements RowMapper<MyUserAccount> {

	@Override
    public MyUserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String id = rs.getString("id");
        String email = rs.getString("email");
        String userName= rs.getString("user_name");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String password = rs.getString("password");
        String role = rs.getString("role");
        boolean enabled = rs.getBoolean("enabled");
 
        return new MyUserAccount(id, email,userName, firstName, lastName, password, role, enabled);
    }
	
}

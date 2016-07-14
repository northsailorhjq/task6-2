package com.jiekexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jiekexueyuan.dao.UserDao;
import com.jikexueyuan.model.User;
import com.jikexueyuan.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement pr;	
	public boolean IsUser(User user) {
		connection=DBUtil.makeConnection();
		String sql="select * from user where username=? and password=?";
		try {
			pr = connection.prepareStatement(sql);
			pr.setString(1,user.getUsername());
			pr.setString(2,user.getPassword());
			ResultSet rSet=pr.executeQuery();
			if (rSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}

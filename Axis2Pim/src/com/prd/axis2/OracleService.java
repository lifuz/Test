package com.prd.axis2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.prd.db.OracleConnect;

public class OracleService {

	public String sayHello(String id) {

		Connection conn;
		try {
			conn = OracleConnect.getConnection();
			String sql = "select * from emp where empno = ?";
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				return "Hello," + rs.getString(2);
			} else {
				return "对不起找不到这个用户！！！";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(new OracleService().sayHello("73655"));
//	}

}

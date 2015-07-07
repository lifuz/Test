package com.prd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 建立与Oracle数据库的连接
 * 
 * @author 李富
 *
 */

public class OracleConnect {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	/**
	 * 
	 * 获取数据库连接
	 * 
	 * @return 数据库连接Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Connection getConnection() throws Exception {

		// 定义数据库的驱动类
		driver = "oracle.jdbc.driver.OracleDriver";
		// 拼接访问的url
		url = "jdbc:oracle:thin:@121.40.199.67:1521:orcl";
		// 设置用户名
		user = "scott";
		// 设置密码
		password = "tiger";
		// 加载 驱动
		Class.forName(driver);

		// 返回数据库连接
		return DriverManager.getConnection(url, user, password);

	}

	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		String sql = "select * from emp";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
	}

}

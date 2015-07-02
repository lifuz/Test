package com.prd.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnect {
	static String driver;
	static String url;
	static String user;
	static String password;

	/**
	 * 
	 * 获取数据库连接
	 * 
	 * @return 数据库连接Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// 定义数据库的驱动类
		driver = "oracle.jdbc.driver.OracleDriver";
		// 拼接访问的url
		url = "jdbc:oracle:thin:@115.29.195.184:1521:orcl";
		// 设置用户名
		user = "mcc2";
		// 设置密码
		password = "mcc";
		// 加载 驱动
		Class.forName(driver);

		// 返回数据库连接
		return DriverManager.getConnection(url, user, password);
	}
}

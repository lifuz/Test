package com.prd.axis;

import java.sql.Connection;

import com.prd.connect.OracleConnect;

public class OracleTest {
	
	public String getName(int id ) {
		
		
		try {
			Connection conn = OracleConnect.getConnection();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

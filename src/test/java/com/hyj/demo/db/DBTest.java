package com.hyj.demo.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBTest {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Context context=new InitialContext();
			DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/oracle-local");
			conn=dataSource.getConnection();
			System.out.println(conn);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

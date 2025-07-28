package ch10_02_throws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
	
	public Connection conn() throws SQLException{
		String url = "DB 접속주소";
		
		return DriverManager.getConnection(url, "tiger", "12345");
	}
}

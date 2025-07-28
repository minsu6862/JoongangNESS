package ch10_02_throws;

import java.sql.Connection;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		ThrowsSample ts = new ThrowsSample();


		try {
			ts.ZeroDivid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("0나누기 에러");
		}
		
		
		System.out.println("10번 라인입니다!");

		Connection conn = null;
		DBTest db = new DBTest();
		try {
			conn = db.conn();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}

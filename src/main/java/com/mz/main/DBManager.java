package com.mz.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업을 할때 매번 연결코드를 쓴 이후 작업 해옴

// 그거 AOP 하자
public class DBManager {
	
	// db작업시엔 어쩃든 연결 해야됨
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String url = "jdbc:oracle:thin:@db202204301707_medium?TNS_ADMIN=C://mzz/Wallet_DB202204301707";
//		return DriverManager.getConnection(url, "ADMIN", "LMJsoldesk802");
		return DriverManager.getConnection(url, "c##mz1004", "mz1004");
	}
	
	
	// 닫을게 많은데 한번에 닫기
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}

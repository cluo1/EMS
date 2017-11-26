package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/super?useUnicode=true&characterEncoding=utf-8";
			String user ="root";
			String pwd = "root";
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return conn;
	}
	public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

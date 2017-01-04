package zipcode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ZipcodeUtil {
	private static final ZipcodeUtil instance = new ZipcodeUtil();

	public static Connection getInstance() {
		return instance.getConnection();
	}
	
	private ZipcodeUtil(){}
	
	public static Connection getConnection(){
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/zipcode";
		String user = "root";
		String password = "rootroot";
		
		try {
			connection = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.err.println("확인  ");
			e.printStackTrace();
		}
		
		return connection;
	}
}

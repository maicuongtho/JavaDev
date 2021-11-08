package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ketNoiDB {
	public static Connection MoKetNoi(String TenCSDL, String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		// Bước 2. Tạo và giữ kết nối đến một CSDL cụ thể
		String urlDB ="jdbc:mysql://localhost:3306/"+TenCSDL;
	    try {
		   return DriverManager.getConnection(urlDB,user,pass);
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	   }
	   return null; 
	}
	
}

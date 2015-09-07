package Connet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {

	private static Connection conn=null;
	private static ResultSet rs=null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lixiaojian";
		String user = "root";


		String password = "root";
		try {
			Class.forName(driver);
			
				conn = DriverManager.getConnection(url,user,password);
				Statement statement = conn.createStatement();
				String sql = "select * from ed";
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					System.out.println(id);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

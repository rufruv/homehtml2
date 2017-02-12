package util;
import java.sql.*;

import constants.Database;
public class JdbcTest {
	public static void main(String[] args) {
		try {
			Class.forName(Database.ORACLE_DRIVER);  // reflection
			Connection connection = DriverManager.getConnection(Database.ORACLE_URL, 
											 Database.USERNAME, Database.PASSWORD);
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM Member WHERE id='hong'", result="";
			ResultSet set = stmt.executeQuery(sql);
			while(set.next()){
				result = set.getString("name");
			}
			System.out.println("회원이름: "+result);
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
	}
}
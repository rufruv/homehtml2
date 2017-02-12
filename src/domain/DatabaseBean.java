package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.Database;

public class DatabaseBean {
	private String driver, url, username, password;  // getter를 만들지 않으면 아무도 모든다.
	private Connection connection;
	
	public DatabaseBean(String driver, String url, 
			            String username, String password) {
		this.driver = driver;                        // setter역할
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public Connection getConnection() { 
		/*Connection c = null;   // interfaces(Connection)는 객체가 아니기 때문에 new 생성자를 만들수 없다. */
		try {
			Class.forName(Database.ORACLE_DRIVER); //set!
			connection = DriverManager.getConnection(
					     Database.ORACLE_URL,
					     Database.USERNAME,
					     Database.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
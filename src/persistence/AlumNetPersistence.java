package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.ANUtil;

public class AlumNetPersistence {
	private Connection conn = null;
	private String url = "";
	
	//connect to database
	public void connect() throws SQLException, Exception {
		ANUtil util = new ANUtil();
		if (conn != null) {
			conn.close();
			
			conn = DriverManager.getConnection(util.getURL());
		} else {
			conn = DriverManager.getConnection(url);
		}
	}
	
	//close connection
	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}
}

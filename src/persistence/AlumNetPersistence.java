package persistence;

import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlumNetPersistence {
	private Connection conn = null;
	
	//connect to database
	public void connect() throws Exception {
		ANUtil util = new ANUtil();
		close();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(util.getURL(), util.getUser(), util.getPassword());
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

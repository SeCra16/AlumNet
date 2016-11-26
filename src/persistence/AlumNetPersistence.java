package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.ANUtil;

public class AlumNetPersistence {
	private Connection conn = null;
	
	//connect to database
	public void connect() throws SQLException, Exception {
		ANUtil util = new ANUtil();
		if (conn != null) {
			conn.close();
			
			conn = DriverManager.getConnection(util.getURL(), util.getUser(), util.getPassword());
		} else {
			throw new Exception("Bad login credentials... check config.properties");
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

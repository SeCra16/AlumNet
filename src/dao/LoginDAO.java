package dao;
import dto.LoginDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Josh Archer
 * This class will serve as the dao (Database Access Object)
 * for the LOGIN table in the database
 *
 * NOTE: COULD HAVE NULL POINTER ERRORS DUE TO CHECKING FOR CERTAIN VALUES BEFORE CONFIRMING dto OBJECT IS NOT NULL
 */
public class LoginDAO {
	private Connection conn = null;

	//constructor
	public LoginDAO(Connection conn) {
		this.conn = conn;
	}

	public String select(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto.getEmail().equals("") || dto.getEmail() == null || dto == null) {
			throw new Exception("dto passed cannot be null nor can the email be");
		} else {
			String sql = "SELECT * FROM ALUMNET.dbo.Login WHERE Email=? and Password=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPassword());

			ResultSet rs = ps.executeQuery();
			String type = null;
			
			//get the type so we can get the user dto
			while(rs.next()) {
				type = rs.getString("type").toLowerCase();
			}
			
			return type;
		}
	}

	public void insert(LoginDTO dto) throws com.microsoft.sqlserver.jdbc.SQLServerException, Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {

			//Check if any field of the dto is empty *NOTE: Only picture can be null/empty*
			if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt insert");
			} else if (dto.getPassword() == null) {
				throw new Exception("Password cannot be empty... failing to attempt insert");
			}

			//We know every field is initialized so we can insert
			String sql = "INSERT INTO ALUMNET.dbo.Login (Email, Password, Type) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, dto.getEmail());
			stmt.setString(2, dto.getPassword());
			stmt.setString(3, dto.getType());

			stmt.execute();
		}
	}

	public void delete(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Has to have  id so we can delete
			if (dto.getEmail() == null) {
				throw new Exception("Email cannot be null...");
			} else {
//				TODO: NEED TO PROPAGATE THE DELETE TO ALL TABLES
				String sql = "DELETE FROM ALUMNET.dbo.Login WHERE Email=?";
				PreparedStatement stmt = conn.prepareStatement(sql);

				stmt.setString(1, dto.getEmail());

				stmt.execute();
			}
		}
	}

	public void update(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			String sql = "UPDATE ALUMNET.dbo.Login SET Email=?, Password=? WHERE Email=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, dto.getEmail());
			stmt.setString(2, dto.getPassword());
			stmt.setString(3, dto.getEmail());
			stmt.executeUpdate();
		}
	}
}
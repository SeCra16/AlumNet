package dao;
import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;

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

	public UserDTO select(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto.getEmail().equals("") || dto.getEmail() == null || dto == null) {
			throw new Exception("dto passed cannot be null nor can the email be");
		} else {
			String sql = "SELECT * FROM ALUMNET.dbo.Login WHERE ID=? and Email=? and Password=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, dto.getID());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPassword());

			ResultSet rs = ps.executeQuery();

			StudentDTO sDTO = new StudentDTO();
			AlumniDTO aDTO = new AlumniDTO();

			while(rs.next()) {
				int i = rs.getInt("ID");

				sDTO.setStudentID(i);
				aDTO.setAlumniID(i);
			}

			//try to do a select

			sDTO = (StudentDTO) new StudentDAO(conn).select(sDTO);

			if (sDTO.getFirstName().equals("") || sDTO.getFirstName() == null) {
				aDTO = (AlumniDTO) new AlumniDAO(conn).select(aDTO);

				if (aDTO.getFirstName().equals("") || sDTO.getFirstName() == null) {
					return null;
				} else {
					return aDTO;
				}
			} else {
				return sDTO;
			}
		}
	}

	public void insert(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {

			//Check if any field of the dto is empty *NOTE: Only picture can be null/empty*
			if (dto.getID() == Integer.MIN_VALUE) {
				throw new Exception("ID cannot be empty... failing to attempt insert");
			} else if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt insert");
			} else if (dto.getPassword() == null) {
				throw new Exception("Password cannot be empty... failing to attempt insert");
			}

			//We know every field is initialized so we can insert
			String sql = "INSERT INTO ALUMNET.dbo.Login (ID, Email, Password) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, dto.getID());
			stmt.setString(2, dto.getEmail());
			stmt.setString(3, dto.getPassword());

			stmt.executeQuery();
		}
	}

	public void delete(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Has to have  id so we can delete
			if (dto.getID() == Integer.MIN_VALUE) {
				throw new Exception("ID cannot be null...");
			} else {
				String sql = "DELETE FROM ALUMNET.dbo.Login WHERE ID=?";
				PreparedStatement stmt = conn.prepareStatement(sql);

				stmt.setInt(1, dto.getID());

				stmt.executeQuery();
			}
		}
	}

	public void update(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			String sql = "UPDATE ALUMNET.dbo.Login SET Email=?, Password=? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, dto.getEmail());
			stmt.setString(2, dto.getPassword());
			stmt.setInt(3, dto.getID());
			stmt.executeUpdate();
		}
	}
}
package dao;
import java.sql.*;

import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;

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
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM LOGIN WHERE Email=" + dto.getEmail() + " and Password=" + dto.getPassword());
			
			if(rs.getInt("ID") != Integer.MIN_VALUE) {
				rs = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID=" + rs.getInt("ID") + " UNION SELECT * FROM Alumni "
						+ "WHERE Alumni_ID=" + rs.getInt("ID"));
			}
			
			//Try to return the dto object for the login user
			try {
				
				if (rs.getInt("Student_ID") != Integer.MIN_VALUE) {
					StudentDTO rDTO = new StudentDTO();
					
					rDTO.setStudentID(rs.getInt("Student_ID"));
					rDTO.setFirstName(rs.getString("First_Name"));
					rDTO.setLastName(rs.getString("Last_Name"));
					rDTO.setExpectedGraduation(rs.getDate("Expected_Graduation"));
					rDTO.setEmail(rs.getString("Contact_Email"));
					rDTO.setMajor(rs.getString("Major"));
					rDTO.setResume(rs.getBlob("Resume"));
					rDTO.setActive(rs.getBoolean("Active"));
					rDTO.setPicture(rs.getClob("Picture"));
					
					return rDTO;
				} 
				
				if (rs.getInt("Alumni_ID") != Integer.MIN_VALUE) {
					AlumniDTO rDTO = new AlumniDTO();
					
					rDTO.setAlumniID(rs.getInt("Alumni_ID"));
					rDTO.setFirstName(rs.getString("First_Name"));
					rDTO.setLastName(rs.getString("Last_Name"));
					rDTO.setGraduationDate(rs.getDate("Graduation_Date"));
					rDTO.setEmail(rs.getString("Contact_Email"));
					rDTO.setCompany(rs.getString("Company"));
					rDTO.setJobTitle(rs.getString("Job_Title"));
					rDTO.setJobField(rs.getString("Job_Field"));
					rDTO.setActive(rs.getBoolean("Active"));
					rDTO.setPicture(rs.getClob("Picture"));
					
					return rDTO;
				}
				
			} catch (Exception e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new dto did not");
			}
		}
		return null;
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
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO LOGIN VALUES (" + dto.getID() + ","+ dto.getEmail() + "," 
				+ dto.getPassword() + ")");
		}
	}

	public void delete(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Has to have  id so we can delete 
			if (dto.getID() == Integer.MIN_VALUE || dto == null || dto.getEmail() == null) {
				throw new Exception("ID and Email cannot be null...");
			} else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("DELETE FROM LOGIN WHERE ID=" + dto.getID() + " and Email=" + dto.getEmail());
			}
		}
	}

	public void update(LoginDTO dto) throws Exception {
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Need to check if non-null values in dto are null
			if (dto.getEmail() != null) {
				if (dto.getPassword() != null || dto.getPassword() == "") {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("UPDATE LOGIN SET Email=" + dto.getEmail() + ",Password=" + dto.getPassword()
						+ " WHERE Email=" + dto.getEmail());
				} else {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("UPDATE LOGIN SET Email=" + dto.getEmail() + " WHERE Email=" + dto.getEmail());
				}
			} else {
				throw new Exception("Email cannot be empty");
			}
		}
	}
}

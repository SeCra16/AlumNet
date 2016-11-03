package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.StudentDTO;
import dto.UserDTO;


/*
 * Josh Archer 
 * This class will serve as the dao (Database Access Object)
 * for the STUDENT table in the database
 * 
 * NOTE: COULD HAVE NULL POINTER ERRORS DUE TO CHECKING FOR CERTAIN VALUES BEFORE CONFIRMING dto OBJECT IS NOT NULL
 */
public class StudentDAO {
private Connection conn = null;
	
	//constructor
	public StudentDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public UserDTO select(UserDTO DTO) throws SQLException, Exception {
		StudentDTO dto = (StudentDTO) DTO;
		//Check if the dto is null
		if(dto == null || dto.getStudentID() == Integer.MIN_VALUE) {
			throw new Exception("dto passed cannot be null nor can the Id be");
		} else {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE Student_ID=" + dto.getStudentID());
			
			StudentDTO rDTO = new StudentDTO();
			
			try {
				rDTO.setStudentID(rs.getInt("Student_ID"));
				rDTO.setFirstName(rs.getString("First_Name"));
				rDTO.setLastName(rs.getString("Last_Name"));
				rDTO.setExpectedGraduation(rs.getDate("Expected_Graduation"));
				rDTO.setEmail(rs.getString("Contact_Email"));
				rDTO.setMajor(rs.getString("Major"));
				rDTO.setResume(rs.getClob("Resume"));
				rDTO.setActive(rs.getBoolean("Active"));
				rDTO.setPicture(rs.getClob("Picture"));
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....");
			}
			
			return rDTO;
		}
	}

	
	public void insert(UserDTO DTO) throws Exception {
		StudentDTO dto = (StudentDTO) DTO;
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			
			//Check if any field of the dto is empty *NOTE: Only picture can be null/empty*
			if (dto.getStudentID() == Integer.MIN_VALUE) {
				throw new Exception("StudentID cannot be empty... failing to attempt insert");
			} else if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt insert");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt insert");
			} else if (dto.getExpectedGraduation() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt insert");
			} else if (dto.getEmail() == null) {
				throw new Exception("Contact Email cannot be empty... failing to attempt insert");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt insert");
			} else if (dto.getActive() != false || dto.getActive() != true) {
				throw new Exception("Active cannot be empty... failing to attempt insert");
			} 
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO STUDENT VALUES (" + dto.getStudentID() + ","+ dto.getFirstName() + "," 
				+ dto.getLastName() + ","+ dto.getExpectedGraduation() + "," + dto.getEmail() + "," + dto.getMajor() 
				+ ","+ dto.getResume() + ","+ dto.getActive() + "," + dto.getPicture() + ")");
		}
	}

	
	public void delete(UserDTO DTO) throws Exception {
		StudentDTO dto = (StudentDTO) DTO;
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Has to have Student id so we can delete 
			if (dto.getStudentID() == Integer.MIN_VALUE) {
				throw new Exception("Student Id cannot be null");
			} else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("DELETE FROM Student WHERE Student_ID=" + dto.getStudentID());
			}
		}
	}

	
	public UserDTO update(UserDTO DTO) throws SQLException, Exception {
		StudentDTO dto = (StudentDTO) DTO;
		//Check if the dto is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Need to check if non-null values in dto are null
			if (dto.getStudentID() == Integer.MIN_VALUE) {
				throw new Exception("StudentID cannot be empty... failing to attempt update");
			} else if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt update");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt update");
			} else if (dto.getExpectedGraduation() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt update");
			} else if (dto.getEmail() == null) {
				throw new Exception("Contact Email cannot be empty... failing to attempt update");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt update");
			} else if (dto.getActive() != false || dto.getActive() != true) {
				throw new Exception("Active cannot be empty... failing to attempt update");
			}
			
			//We know the values are not null, so time to attempt update
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE Student SET First_Name=" + dto.getFirstName() + ",Last_Name=" + dto.getLastName()
				+ ",Expected_Graduation=" + dto.getExpectedGraduation() + ",Contact_Email=" + dto.getEmail() + ",Major=" + dto.getMajor()
				+ ",Resume=" + dto.getResume() + ",Active=" + dto.getActive() + ",Picture=" + dto.getPicture()
				+ " WHERE Student_ID=" + dto.getStudentID());
			
			//See if update worked then return the updated dto
			rs = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID=" + dto.getStudentID());
			
			StudentDTO rDTO = new StudentDTO();
			
			try {
				rDTO.setStudentID(rs.getInt("Student_ID"));
				rDTO.setFirstName(rs.getString("First_Name"));
				rDTO.setLastName(rs.getString("Last_Name"));
				rDTO.setExpectedGraduation(rs.getDate("Expected_Graduation"));
				rDTO.setEmail(rs.getString("Contact_Email"));
				rDTO.setMajor(rs.getString("Major"));
				rDTO.setResume(rs.getClob("Resume"));
				rDTO.setActive(rs.getBoolean("Active"));
				rDTO.setPicture(rs.getClob("Picture"));
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new dto did not");
			}
			
			return rDTO;
		}
	}

}

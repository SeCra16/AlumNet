package dao;
import java.sql.*;

import dto.AlumniDTO;
import dto.UserDTO;

/*
 * Josh Archer 
 * This class will serve as the dao (Database Access Object)
 * for the Alumni table in the database
 * 
 * NOTE: COULD HAVE NULL POINTER ERRORS DUE TO CHECKING FOR CERTAIN VALUES BEFORE CONFIRMING UserDTO OBJECT IS NOT NULL
 */
public class AlumniDAO {
	private Connection conn = null;
	
	//constructor
	public AlumniDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public UserDTO select(UserDTO DTO) throws Exception {
		//Check if the UserDTO is null
		AlumniDTO dto = (AlumniDTO) DTO;
		if(dto == null || dto.getAlumniID() == Integer.MIN_VALUE) {
			throw new Exception("dto passed cannot be null nor can the Id be");
		} else {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Alumni WHERE Alumni_ID=" + dto.getAlumniID());
			
			AlumniDTO rDTO = new AlumniDTO();
			
			try {
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
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....");
			}
			
			return rDTO;
		}
	}

	
	public void insert(UserDTO DTO) throws Exception {
		//Check if the UserDTO is null
		AlumniDTO dto = (AlumniDTO) DTO;
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			
			//Check if any field of the UserDTO is empty *NOTE: Only picture can be null/empty*
			if (dto.getAlumniID() == Integer.MIN_VALUE) {
				throw new Exception("AlumniID cannot be empty... failing to attempt insert");
			} else if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt insert");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt insert");
			} else if (dto.getGraduationDate() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt insert");
			} else if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt insert");
			} else if (dto.getCompany() == null) {
				throw new Exception("Company cannot be empty... failing to attempt insert");
			} else if (dto.getJobTitle() == null) {
				throw new Exception("Job Title cannot be empty... failing to attempt insert");
			} else if (dto.getJobField() == null) {
				throw new Exception("Job Field cannot be empty... failing to attempt insert");
			}  
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO ALUMNET.dbo.Alumni VALUES (Alumni_ID, First_Name, Last_Name, Graduation_Date, Email, Company, Active) (" + dto.getAlumniID() + ","+ dto.getFirstName() + ","+ dto.getLastName()
				+ "," + dto.getGraduationDate() + ","+ dto.getEmail() + ","+ dto.getCompany() + ","+ dto.getActive() 
				+ dto.getPicture() + ")");
		}
	}

	
	public void delete(UserDTO DTO) throws Exception {
		//Check if the UserDTO is null
		AlumniDTO dto = (AlumniDTO) DTO;
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Has to have alumni id so we can delete 
			if (dto.getAlumniID() == Integer.MIN_VALUE) {
				throw new Exception("Alumni Id cannot be null");
			} else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("DELETE FROM ALUMNET.dbo.Alumni WHERE Alumni_ID=" + dto.getAlumniID());
			}
		}
	}

	
	public UserDTO update(UserDTO DTO) throws Exception {
		AlumniDTO dto = (AlumniDTO) DTO;
		//Check if the UserDTO is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			//Need to check if non-null values in UserDTO are null
			if (dto.getAlumniID() == Integer.MIN_VALUE) {
				throw new Exception("AlumniID cannot be empty... failing to attempt update");
			} else if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt update");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt update");
			} else if (dto.getGraduationDate() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt update");
			} else if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt update");
			} else if (dto.getCompany() == null) {
				throw new Exception("Company cannot be empty... failing to attempt update");
			} else if (dto.getJobTitle() == null) {
				throw new Exception("Job Title cannot be empty... failing to attempt update");
			} else if (dto.getJobField() == null) {
				throw new Exception("Job Field cannot be empty... failing to attempt update");
			} else if (dto.getActive() != true || dto.getActive() != false) {
				throw new Exception("Active cannot be empty... failing to attempt update");
			}
			
			//We know the values are not null, so time to attempt update
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE ALUMNI SET First_Name=" + dto.getFirstName() + ",Last_Name=" + dto.getLastName()
				+ ",Graduation_Date=" + dto.getGraduationDate() + ",Contact_Email=" + dto.getEmail() + ",Company=" + dto.getCompany()
				+ ",Job_Title=" + dto.getJobTitle() + ",Job_Field=" + dto.getJobField() + ",Active=" + dto.getActive() + ",Picture=" + dto.getPicture() 
				+ " WHERE Alumni_ID=" + dto.getAlumniID());
			
			//See if update worked then return the updated dto
			rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Alumni WHERE Alumni_ID=" + dto.getAlumniID());
			
			AlumniDTO rDTO = new AlumniDTO();
			
			try {
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
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new UserDTO did not");
			}
			
			return rDTO;
		}
	}

}

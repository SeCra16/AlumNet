package dao;

import dto.StudentDTO;
import dto.UserDTO;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Random;


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
            String sql = "SELECT * FROM ALUMNET.dbo.Student WHERE Student_ID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getStudentID());

            ResultSet rs = ps.executeQuery();

			StudentDTO rDTO = new StudentDTO();
			
			try {
				while(rs.next()) {
					rDTO.setStudentID(rs.getInt("Student_ID"));
					rDTO.setFirstName(rs.getString("First_Name"));
					rDTO.setLastName(rs.getString("Last_Name"));
					rDTO.setExpectedGraduation(rs.getDate("Expected_Graduation"));
					rDTO.setEmail(rs.getString("Email"));
					rDTO.setMajor(rs.getString("Major"));

                    File file = new File("C:\\Users\\AlumNet\\Downloads\\" + new Random().nextInt() + ".pdf");

                    try (FileOutputStream out = new FileOutputStream(file)) {
                        IOUtils.copy(rs.getBinaryStream("Resume"), out);

                    } catch (Exception e) {
                        //means its null... just continue
                    }
					rDTO.setResume(file);

                    rDTO.setActive(rs.getBoolean("Active"));

                    file = new File("C:\\Users\\AlumNet\\Downloads\\" + new Random().nextInt() + ".pdf");

                    try (FileOutputStream out = new FileOutputStream(file)) {
                        IOUtils.copy(rs.getBinaryStream("Picture"), out);

                    } catch (Exception e) {
                        //means its null or empty.. continue
                    }
                    rDTO.setPicture(file);
				}
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....\n" + e.getMessage());
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
				throw new Exception("Email cannot be empty... failing to attempt insert");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt insert");
			} else if (dto.getActive() != false || dto.getActive() != true) {
				throw new Exception("Active cannot be empty... failing to attempt insert");
			} 
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();

            String sql = "INSERT INTO ALUMNET.dbo.Student (Student_ID, First_Name, Last_Name, Expected_Graduation, Email, Major, Resume, Active, Picture) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = conn.prepareStatement(sql);

            myStmt.setInt(1, dto.getStudentID());
            myStmt.setString(2, dto.getFirstName());
            myStmt.setString(3, dto.getLastName());
            myStmt.setDate(4, (Date) dto.getExpectedGraduation());
            myStmt.setString(5, dto.getEmail());
            myStmt.setString(6, dto.getMajor());

            FileInputStream is = new FileInputStream(dto.getResume());

            myStmt.setBinaryStream(7, is);

            myStmt.setBoolean(8, dto.getActive());

            FileInputStream is2 = new FileInputStream(dto.getPicture());

            myStmt.setBinaryStream(9, is2);

            myStmt.execute();


            /**ResultSet rs = stmt.executeQuery("INSERT INTO ALUMNET.dbo.Student (Student_ID, First_Name, Last_Name, Expected_Graduation, Email, Major, Resume, Active, Picture) VALUES (" + dto.getStudentID() + ","+ dto.getFirstName() + ","
				+ dto.getLastName() + ","+ dto.getExpectedGraduation() + "," + dto.getEmail() + "," + dto.getMajor() 
				+ ","+ dto.getResume() + ","+ dto.getActive() + "," + dto.getPicture() + ")");
             **/
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
				ResultSet rs = stmt.executeQuery("DELETE FROM ALUMNET.dbo.Student WHERE Student_ID=" + dto.getStudentID());
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
				throw new Exception("Email cannot be empty... failing to attempt update");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt update");
			} else if (dto.getActive() != false || dto.getActive() != true) {
				throw new Exception("Active cannot be empty... failing to attempt update");
			}
			
			//We know the values are not null, so time to attempt update
			
			//Statement stmt = conn.createStatement();

            String sql = "UPDATE ALUMNET.dbo.Student SET First_Name=?, Last_Name=?, Expected_Graduation=?, Email=?, Major=?, Resume=?, Active=?, Picture=? WHERE Student_ID=?";

            PreparedStatement myStmt = conn.prepareStatement(sql);

            myStmt.setString(1, dto.getFirstName());
            myStmt.setString(2, dto.getLastName());
            myStmt.setDate(3, (Date) dto.getExpectedGraduation());
            myStmt.setString(4, dto.getEmail());
            myStmt.setString(5, dto.getMajor());

            FileInputStream is = new FileInputStream(dto.getResume());

            myStmt.setBinaryStream(6, is);

            myStmt.setBoolean(7, dto.getActive());

            FileInputStream is2 = new FileInputStream(dto.getPicture());

            myStmt.setBinaryStream(8, is2);

            myStmt.setInt(9, dto.getStudentID());

            myStmt.execute();
			
			//See if update worked then return the updated dto
			ResultSet rs = myStmt.executeQuery("SELECT * FROM ALUMNET.dbo.Student WHERE Student_ID=" + dto.getStudentID());
			
			StudentDTO rDTO;
			
			try {
                rDTO = (StudentDTO) select(dto);
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new dto did not");
			}
			
			return rDTO;
		}
	}

}

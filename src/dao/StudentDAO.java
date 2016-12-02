package dao;

import dto.StudentDTO;
import dto.UserDTO;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
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
		if(dto == null ) {
            throw new Exception("dto passed cannot be null");
        } else {

		    if (dto.getEmail() == null) {
		        throw new Exception("email cannot be null");
            }

			//Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM ALUMNET.dbo.Student WHERE Email=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getEmail());

            ResultSet rs = ps.executeQuery();


			StudentDTO rDTO = new StudentDTO();
			
			try {
				while(rs.next()) {
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

                    try {
                        file.createNewFile();
                    } catch (Exception ex) {
                        System.out.println("Cant create file on pathway");
                    }
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        IOUtils.copy(rs.getBinaryStream("Picture"), out);

                    } catch (Exception e) {
                        System.out.println("Must have null picture");
                    }
                    rDTO.setPicture(file);

                    File f2 = new File("C:\\Users\\AlumNet\\Downloads\\" + new Random().nextInt() + ".pdf");

                    try {
                        f2.createNewFile();
                    } catch (Exception ex) {
                        System.out.println("Cant create file on pathway");
                    }
                    try (FileOutputStream out = new FileOutputStream(f2)) {
                        IOUtils.copy(rs.getBinaryStream("Resume"), out);

                    } catch (Exception e) {
                        System.out.println("Must have null resume");
                    }
                    rDTO.setResume(file);

                    //ps.close();


                    //build the new statement to get all the connections
                    PreparedStatement st = conn.prepareStatement("SELECT * FROM ALUMNET.dbo.Connected WHERE Student_Email=?");

                    st.setString(1, rDTO.getEmail());


                    //run the query to get all connections then store in arraylist to be passed back
                    ResultSet rs2 = st.executeQuery();

                    ArrayList<String> temp = new ArrayList<String>();
                    while (rs2.next()) {
                        temp.add(rs2.getString("Alumni_Email"));
                    }

                    //convert to string[] so we can pass back
                    String[] connections = new String[temp.size()];
                    rDTO.setConnections(temp.toArray(connections));
                    rs2.close();
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
            if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt insert");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt insert");
			} else if (dto.getExpectedGraduation() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt insert");
			} else if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt insert");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt insert");
			}
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();

            String sql = "INSERT INTO ALUMNET.dbo.Student (First_Name, Last_Name, Expected_Graduation, Email, Major, Resume, Active, Picture) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = conn.prepareStatement(sql);

            myStmt.setString(1, dto.getFirstName());
            myStmt.setString(2, dto.getLastName());
            java.sql.Date date = new java.sql.Date(dto.getExpectedGraduation().getTime());
            myStmt.setDate(3, date);
            myStmt.setString(4, dto.getEmail());
            myStmt.setString(5, dto.getMajor());

            //try resume, unless its empty
            try {

                FileInputStream is = new FileInputStream(dto.getResume());

                myStmt.setBinaryStream(6, is);

            } catch (Exception e) {
                System.out.println("no resume so skip ");
                myStmt.setNull(6, Types.VARBINARY);
            }

            myStmt.setBoolean(7, dto.getActive());

            //try picture, unless its empty
            try {

                FileInputStream is2 = new FileInputStream(dto.getPicture());

                myStmt.setBinaryStream(8, is2);

            } catch (Exception e) {
                System.out.println("no picture so skip ");
                myStmt.setNull(8, Types.VARBINARY);
            }

            myStmt.execute();

            //do stuff if we have ocnnections
            if (dto.getConnections() != null) {

                String[] connections = dto.getConnections();
                for (String connection : connections) {
                    sql = "INSERT INTO ALUMNET.dbo.Connected (Alumni_Email, Student_Email) VALUES (?,?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, connection);
                    ps.setString(2, dto.getEmail());
                    ps.execute();
                }
            }


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
			if (dto.getEmail() == null) {
				throw new Exception("email cannot be null");
			} else {
				Statement stmt = conn.createStatement();
                stmt.execute("DELETE FROM ALUMNET.dbo.Connected WHERE Student_Email=" + dto.getEmail());
				stmt.execute("DELETE FROM ALUMNET.dbo.Student WHERE Email=" + dto.getEmail());
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
            if (dto.getFirstName() == null) {
				throw new Exception("First Name cannot be empty... failing to attempt update");
			} else if (dto.getLastName() == null) {
				throw new Exception("Last Name cannot be empty... failing to attempt update");
			} else if (dto.getExpectedGraduation() == null) {
				throw new Exception("Graduation Date cannot be empty... failing to attempt update");
			} else if (dto.getEmail() == null) {
				throw new Exception("Email cannot be empty... failing to attempt update");
			} else if (dto.getMajor() == null) {
				throw new Exception("Major cannot be empty... failing to attempt update");
			}
			
			//We know the values are not null, so time to attempt update
			
			//Statement stmt = conn.createStatement();

            String sql = "UPDATE ALUMNET.dbo.Student SET First_Name=?, Last_Name=?, Expected_Graduation=?, Email=?, Major=?, Resume=?, Active=?, Picture=? WHERE Email=?";

            PreparedStatement myStmt = conn.prepareStatement(sql);

            myStmt.setString(1, dto.getFirstName());
            myStmt.setString(2, dto.getLastName());
            java.sql.Date date = new java.sql.Date(dto.getExpectedGraduation().getTime());
            myStmt.setDate(3, date);
            myStmt.setString(4, dto.getEmail());
            myStmt.setString(5, dto.getMajor());

            //try resume, unless its empty
            try {

                FileInputStream is = new FileInputStream(dto.getResume());

                myStmt.setBinaryStream(6, is);

            } catch (Exception e) {
                System.out.println("no resume so skip ");
                myStmt.setNull(6, Types.VARBINARY);
            }

            myStmt.setBoolean(7, dto.getActive());

            //try picture, unless its empty
            try {

                FileInputStream is = new FileInputStream(dto.getPicture());

                myStmt.setBinaryStream(8, is);

            } catch (Exception e) {
                System.out.println("no picture so skip ");
                myStmt.setNull(8, Types.VARBINARY);
            }

            myStmt.setString(9, dto.getEmail());

            myStmt.execute();
			
			//See if update worked then return the updated dto
			ResultSet rs = myStmt.executeQuery("SELECT * FROM ALUMNET.dbo.Student WHERE Email=" + dto.getEmail());
			
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

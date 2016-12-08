package dao;

import dto.StudentDTO;
import dto.UserDTO;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

//					start setting resume
                    File file = null;
                    try {
                        file = File.createTempFile("" + new Random().nextInt(), ".pdf");
                    } catch (Exception es) {
                        System.out.println(es.getMessage());
                    }
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        IOUtils.copy(rs.getBinaryStream("Resume"), out);

                    } catch (IOException e) {
                        System.out.println("Must have empty Resume");
                        file = null;
                    } catch (Exception ex) {
                        String error = ex.getMessage();
                        System.out.println(error);
                    }
                    if (file != null)
					rDTO.setResume(file);
//                   end set resume

                    //set active
                    rDTO.setActive(rs.getBoolean("Active"));

//                    start setting picture
                    file = null;

                    try {
                        file = File.createTempFile("" + new Random().nextInt(), ".jpg");
                    } catch (Exception ex) {
                        String t = ex.getMessage();
                        System.out.println("Cant create file on pathway.." + t);
                    }
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        IOUtils.copy(rs.getBinaryStream("Picture"), out);

                    } catch (IOException e) {
                        System.out.println("Must have null picture");
                        file = null;
                    } catch (Exception ex) {
                        String s = ex.getMessage();
                        System.out.println(s);
                    }
                    if (file != null)
                        rDTO.setPicture(file);


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
                //need to clear the other tables first
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM AlumNet.dbo.Messages WHERE Student_Email=?");
                stmt.setString(1, dto.getEmail());
                stmt.execute();
                stmt.close();


                stmt = conn.prepareStatement("DELETE FROM ALUMNET.dbo.Connected WHERE Student_Email=?");
                stmt.setString(1, dto.getEmail());
                stmt.execute();
                stmt.close();

                stmt = conn.prepareStatement("DELETE FROM ALUMNET.dbo.Student WHERE Email=?");
                stmt.setString(1, dto.getEmail());
                stmt.execute();
                stmt.close();

                stmt = conn.prepareStatement("DELETE FROM ALUMNET.dbo.Login WHERE Email=?");
                stmt.setString(1, dto.getEmail());
                stmt.execute();
                stmt.close();
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


//			TODO: UPDATE CONNECTIONS AND MESSAGES WITH NEW VALUE IF EMAIL CHANGES
            //How to update? Need to delete and store then reinsert
			
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

            //execute and close
            myStmt.execute();
            myStmt.close();



            //build new statement
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ALUMNET.dbo.Student WHERE Email=?");
            ps.setString(1, dto.getEmail());

            //See if update worked then return the updated dto
			ResultSet rs = ps.executeQuery();

			ps.close();
			
			StudentDTO rDTO;
			
			try {
                rDTO = (StudentDTO) select(dto);
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new dto did not");
			}
			
			return rDTO;
		}
	}

    public StudentDTO insertConnections(StudentDTO studentDTO) throws Exception {
        StudentDTO dto = studentDTO;
        //Check if the UserDTO is null
        if(dto == null) {
            throw new Exception("dto passed cannot be null");
        } else {
            //Check if any field of the UserDTO is empty
            if (dto.getConnections() == null) {
                throw new Exception("Connections cannot be empty... failing to attempt insert");
            }

            for (String connection : dto.getConnections()) {
                String sql = "INSERT INTO ALUMNET.dbo.Connected (Alumni_Email, Student_Email) VALUES (?,?);";
                PreparedStatement myStmt = conn.prepareStatement(sql);


                myStmt.setString(1, connection);
                myStmt.setString(2, dto.getEmail());
            }

            StudentDTO rDTO;
            try {
                rDTO = (StudentDTO) select(dto);
            } catch (SQLException e) {
                throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new UserDTO did not\n" + e.getMessage());
            }

            return rDTO;
        }
    }
}

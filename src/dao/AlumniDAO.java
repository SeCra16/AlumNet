package dao;

import dto.AlumniDTO;
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
			    while (rs.next()) {
                    rDTO.setAlumniID(rs.getInt("Alumni_ID"));
                    rDTO.setFirstName(rs.getString("First_Name"));
                    rDTO.setLastName(rs.getString("Last_Name"));
                    rDTO.setGraduationDate(rs.getDate("Graduation_Date"));
                    rDTO.setEmail(rs.getString("Email"));
                    rDTO.setCompany(rs.getString("Company"));
                    rDTO.setJobTitle(rs.getString("Job_Title"));
                    rDTO.setJobField(rs.getString("Job_Field"));
                    rDTO.setActive(rs.getBoolean("Active"));

                    File file = new File("C:\\Users\\AlumNet\\Downloads\\" + new Random().nextInt() + ".pdf");

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
                }


                Statement st = conn.createStatement();
                ResultSet rs2 = st.executeQuery("SELECT Student_ID FROM ALUMNET.dbo.Connected WHERE Alumni_ID=" + dto.getAlumniID());

                int i = 0;
			    int[] temp = new int[10000];
                while (rs2.next()) {
			        temp[i++] = rs2.getInt("Student_ID");
                }

                rDTO.setConnections(temp);
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database...." + e.getMessage());
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
			}


			String sql = "INSERT INTO ALUMNET.dbo.Alumni (Alumni_ID, First_Name, Last_Name, Graduation_Date, Email, Company, Job_Title, Job_Field, Active, Picture) VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement myStmt = conn.prepareStatement(sql);

			myStmt.setInt(1, dto.getAlumniID());
			myStmt.setString(2, dto.getFirstName());
			myStmt.setString(3, dto.getLastName());
			java.sql.Date date = new java.sql.Date(dto.getGraduationDate().getTime());
			myStmt.setDate(4, date);
			myStmt.setString(5, dto.getEmail());
			myStmt.setString(6, dto.getCompany());
			myStmt.setString(7, dto.getJobTitle());
			myStmt.setString(8, dto.getJobField());
			myStmt.setBoolean(9, dto.getActive());

            //try picture, unless its empty
            try {

                FileInputStream is = new FileInputStream(dto.getPicture());

                myStmt.setBinaryStream(10, is);

            } catch (Exception e) {
                System.out.println("no picture so skip ");
                myStmt.setNull(10, Types.VARBINARY);
            }

			myStmt.execute();

			//do stuff if we have ocnnections
            if (dto.getConnections() != null) {
                //check the max column index of connection id
                int max = 0;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT MAX(Connection_ID) FROM ALUMNET.dbo.Connected");
                while (rs.next()) {
                    max = rs.getInt(0);
                }
                int[] connections = dto.getConnections();
                for (int connection : connections) {
                    max++;
                    sql = "INSERT INTO ALUMNET.dbo.Connected (Alumni_ID, Student_ID, Connection_ID) VALUES (?,?,?)";
                    PreparedStatement ps = conn.prepareCall(sql);
                    ps.setInt(1, dto.getAlumniID());
                    ps.setInt(2, connection);
                    ps.setInt(3, max);
                    ps.execute();
                }
            }
			//We know every field is initialized so we can insert
			/**Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( + dto.getAlumniID() + ","+ dto.getFirstName() + ","+ dto.getLastName()
				+ "," + dto.getGraduationDate() + ","+ dto.getEmail() + ","+ dto.getCompany() + ","+ dto.getActive() 
				+ dto.getPicture() + ")");**/
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
				stmt.execute("DELETE FROM ALUMNET.dbo.Connected WHERE Alumni_ID=" + dto.getAlumniID());
				stmt.execute("DELETE FROM ALUMNET.dbo.Alumni WHERE Alumni_ID=" + dto.getAlumniID());
			}
		}
	}

	
	public UserDTO update(UserDTO DTO) throws Exception {
		AlumniDTO dto = (AlumniDTO) DTO;
		//Check if the UserDTO is null
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
            }
			
			//We know the values are not null, so time to attempt update

            String sql = "UPDATE ALUMNET.dbo.Alumni set First_Name=?, Last_Name=?, Graduation_Date=?, Email=?, Company=?, Job_Title=?, Job_Field=?, Active=?, Picture=? WHERE Alumni_ID=?";
            PreparedStatement myStmt = conn.prepareStatement(sql);


            myStmt.setString(1, dto.getFirstName());
            myStmt.setString(2, dto.getLastName());
			java.sql.Date date = new java.sql.Date(dto.getGraduationDate().getTime());
            myStmt.setDate(3, date);
            myStmt.setString(4, dto.getEmail());
            myStmt.setString(5, dto.getCompany());
            myStmt.setString(6, dto.getJobTitle());
            myStmt.setString(7, dto.getJobField());
            myStmt.setBoolean(8, dto.getActive());

            //try picture, unless its empty
            try {

                FileInputStream is = new FileInputStream(dto.getPicture());

                myStmt.setBinaryStream(9, is);

            } catch (Exception e) {
                System.out.println("no picture so skip ");
                myStmt.setNull(9, Types.VARBINARY);
            }

            myStmt.setInt(10, dto.getAlumniID());
            myStmt.execute();

			//See if update worked then return the updated dto
			conn.createStatement().executeQuery("SELECT * FROM ALUMNET.dbo.Alumni WHERE Alumni_ID=" + dto.getAlumniID());
			
			AlumniDTO rDTO;
			
			try {
				rDTO = (AlumniDTO) select(dto);
			} catch (SQLException e) {
				throw new SQLException("Problem with data pulled from Database....update may of worked but selection of new UserDTO did not\n" + e.getMessage());
			}
			
			return rDTO;
		}
	}

}

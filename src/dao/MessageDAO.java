package dao;
import dto.MessageDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Josh Archer 
 * This class will serve as the dao (Database Access Object)
 * for the Message table in the database
 * 
 * NOTE: COULD HAVE NULL POINTER ERRORS DUE TO CHECKING FOR CERTAIN VALUES BEFORE CONFIRMING UserDTO OBJECT IS NOT NULL
 */
public class MessageDAO {
	private Connection conn = null;
	
	//constructor
	public MessageDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public MessageDTO select(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		MessageDTO rDTO = new MessageDTO();

		if(dto == null) {
			throw new Exception("dto passed cannot be null nor can the Id be");
		} else {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			if (dto.getMessageID() != Integer.MIN_VALUE) { 
				rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Message_ID=" + dto.getMessageID());
			}
			else if (dto.getAlumnusEmail() != null) {
				rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Alumni_Email=" + dto.getAlumnusEmail());
			} else if (dto.getStudentEmail() != null) {
				rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Student_Email=" + dto.getStudentEmail());
			} else {
				throw new Exception ("Message ID, Alumnus Email, or Student Email must have a value");
			}
			
			//get values
			while (rs.next()) {
				rDTO.setMessageID(rs.getInt("Message_ID"));
				rDTO.setAlumnusEmail(rs.getString("Alumni_Email"));
				rDTO.setStudentEmail(rs.getString("Student_Email"));
				rDTO.setMessage(rs.getString("Message"));
			}
				
		}
		return rDTO;
	}

	
	public void insert(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			
			//Check if any field of the UserDTO is empty *NOTE: Only picture can be null/empty*
			if (dto.getMessageID() == Integer.MIN_VALUE) {
				throw new Exception("MessageID cannot be empty... failing to attempt insert");
			} else if (dto.getMessage() == null) {
				throw new Exception("Message cannot be empty... failing to attempt insert");
			} else if (dto.getAlumnusEmail() == null) {
				throw new Exception("Alumnus email cannot be empty... failing to attempt insert");
			} else if (dto.getStudentEmail() == null) {
				throw new Exception("Student email cannot be empty... failing to attempt insert");
			}
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();
            String sql = "INSERT INTO ALUMNET.dbo.Messages (Message_ID, Alumni_Email, Student_Email, Message) VALUES (" + dto.getMessageID() + ","+ dto.getAlumnusEmail() + ",'"
                    + "," + dto.getStudentEmail() + "," + dto.getMessage() + "')";
			stmt.execute(sql);
		}
	}

}
